package com.api.magalu.service;

import com.api.magalu.dto.CommunicationDTO;
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

    public void save(CommunicationDTO communicationDTO) {
        Status pendingStatus = statusRepository.findByDescription("pending").orElseThrow();
        communicationDTO.setStatus(pendingStatus);
        Communication communication = mappingService.toModel(communicationDTO);
        communicationRepository.save(communication);
    }

    public CommunicationDTO getById(Long id) {
        Communication communication = communicationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Communication not found with this id: " + id)
        );
        return mappingService.toDto(communication);
    }

    public CommunicationDTO update(Long id, CommunicationDTO communicationDTO) {
        Communication communication = communicationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Communication not found with this id: " + id)
        );
        mappingService.toModel(communicationDTO, communication);
        Communication updatedCommunication = communicationRepository.save(communication);
        return mappingService.toDto(updatedCommunication);
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
        Status cancelledStatus = statusRepository.findByDescription("cancelled").orElseThrow();
        List<Communication> communications = communicationRepository.findByStatusInAndDateTimeBefore(List.of(cancelledStatus, pendingStatus), dateTime);
        communications.forEach(
                communication -> {
                    try {
                        mapStrategy.get(communication.getChannel().getDescription()).send(communication);
                        communication.setStatus(successStatus);
                    } catch (Exception e) {
                        log.error("error sending communication: {}", e.getLocalizedMessage());
                        communication.setStatus(cancelledStatus);
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

    public Page<CommunicationDTO> getAll(Pageable pageable) {
        return communicationRepository.findAll(pageable).map(
                communication -> mappingService.toDto(communication)
        );
    }

}
