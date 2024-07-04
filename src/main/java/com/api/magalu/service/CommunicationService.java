package com.api.magalu.service;

import com.api.magalu.dto.CommunicationDTO;
import com.api.magalu.exception.EntityNotFoundException;
import com.api.magalu.model.Communication;
import com.api.magalu.model.Status;
import com.api.magalu.repository.CommunicationRepository;
import com.api.magalu.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CommunicationService {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private CommunicationRepository communicationRepository;

    @Autowired
    private StatusRepository statusRepository;

    public void save(CommunicationDTO communicationDTO) {
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
        Status pendingStatus = statusRepository.findByDescription("pending").orElseThrow();
        List<Communication> communications = communicationRepository.findByStatusAndDateTimeBefore(pendingStatus, dateTime);
        communications.forEach(sendCommunication());
    }

    private Consumer<Communication> sendCommunication() {
        Status successStatus = statusRepository.findByDescription("success").orElseThrow();
        return communication -> {

            // TODO - send communication

            communication.setStatus(successStatus);
            communicationRepository.save(communication);
        };
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
