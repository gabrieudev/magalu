package com.api.magalu.service;

import com.api.magalu.dto.CommunicationDTO;
import com.api.magalu.model.Communication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    @Autowired
    private ModelMapper modelMapper;

    public Communication toModel(CommunicationDTO communicationDTO) {
        return modelMapper.map(communicationDTO, Communication.class);
    }

    public CommunicationDTO toDto(Communication communication) {
        return modelMapper.map(communication, CommunicationDTO.class);
    }

    public void toModel(CommunicationDTO communicationDTO, Communication communication) {
        modelMapper.map(communicationDTO, communication);
    }

}
