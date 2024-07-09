package com.api.magalu.controller.dto;

import com.api.magalu.model.Channel;
import com.api.magalu.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationResponseDTO {

    private Long id;

    private String receiver;

    private String message;

    private LocalDateTime dateTime;

    private Channel channel;

    private Status status;

}
