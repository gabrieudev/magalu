package com.api.magalu.controller.dto;

import com.api.magalu.model.Channel;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationRequestDTO {
    @NotBlank
    private String receiver;

    @NotBlank
    private String message;

    @NotNull
    @Future
    private LocalDateTime dateTime;

    @NotNull
    private Channel channel;

}
