package com.api.magalu.service;

import com.api.magalu.controller.dto.CommunicationRequestDTO;
import com.api.magalu.controller.dto.CommunicationResponseDTO;
import com.api.magalu.exception.EntityNotFoundException;
import com.api.magalu.model.Communication;
import com.api.magalu.model.Status;
import com.api.magalu.repository.CommunicationRepository;
import com.api.magalu.repository.StatusRepository;
import com.api.magalu.service.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CommunicationService {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private CommunicationRepository communicationRepository;

    @Autowired
    private StatusRepository statusRepository;

    public void save(CommunicationRequestDTO communicationRequestDTO) {
        Status pendingStatus = statusRepository.findByDescription("pending").orElseThrow();
        Communication communication = mappingService.toModel(communicationRequestDTO);
        communication.setStatus(pendingStatus);
        communicationRepository.save(communication);
    }

    public CommunicationResponseDTO getById(Long id) {
        Communication communication = communicationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Communication not found with this id: " + id)
        );
        return mappingService.toResponse(communication);
    }

    public CommunicationResponseDTO update(Long id, CommunicationRequestDTO communicationRequestDTO) {
        Communication communication = communicationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Communication not found with this id: " + id)
        );
        mappingService.toModel(communicationRequestDTO, communication);
        Communication updatedCommunication = communicationRepository.save(communication);
        return mappingService.toResponse(updatedCommunication);
    }

    public void send(LocalDateTime dateTime) {
        Map<String, ChannelServiceStrategy> mapStrategy = Map.of(
                "email", new EmailChannelService(),
                "SMS", new SmsChannelService(),
                "push", new PushChannelService(),
                "whatsapp", new WhatsappChannelService()
        );
        Status pendingStatus = statusRepository.findByDescription("pending").orElseThrow();
        Status successStatus = statusRepository.findByDescription("success").orElseThrow();
        Status errorStatus = statusRepository.findByDescription("error").orElseThrow();
        List<Communication> communications = communicationRepository.findByStatusInAndDateTimeBefore(List.of(errorStatus, pendingStatus), dateTime);
        communications.forEach(
                communication -> {
                    try {
                        mapStrategy.get(communication.getChannel().getDescription()).send(communication);
                        communication.setStatus(successStatus);
                    } catch (Exception e) {
                        log.error("error sending communication: {}", e.getLocalizedMessage());
                        communication.setStatus(errorStatus);
                    }
                    communicationRepository.save(communication);
                }
        );
    }

    public void cancel(Long id) {
        Communication communication = communicationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Communication not found with this id: " + id)
        );
        Status cancelledStatus = statusRepository.findByDescription("cancelled").orElseThrow();
        communication.setStatus(cancelledStatus);
        communicationRepository.save(communication);
    }

    public void delete(Long id) {
        Communication communication = communicationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Communication not found with this id: " + id)
        );
        communicationRepository.delete(communication);
    }

    public Page<CommunicationResponseDTO> getAll(Pageable pageable) {
        return communicationRepository.findAll(pageable).map(
                communication -> mappingService.toResponse(communication)
        );
    }

}
