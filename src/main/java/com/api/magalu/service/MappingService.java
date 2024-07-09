package com.api.magalu.service;

import com.api.magalu.controller.dto.CommunicationRequestDTO;
import com.api.magalu.controller.dto.CommunicationResponseDTO;
import com.api.magalu.model.Communication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    @Autowired
    private ModelMapper modelMapper;

    public Communication toModel(CommunicationRequestDTO communicationRequestDTO) {
        return modelMapper.map(communicationRequestDTO, Communication.class);
    }

    public CommunicationResponseDTO toResponse(Communication communication) {
        return modelMapper.map(communication, CommunicationResponseDTO.class);
    }

    public void toModel(CommunicationRequestDTO communicationRequestDTO, Communication communication) {
        modelMapper.map(communicationRequestDTO, communication);
    }

}
