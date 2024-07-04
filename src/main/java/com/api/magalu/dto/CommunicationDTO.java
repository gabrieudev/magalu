package com.api.magalu.dto;

import com.api.magalu.model.Channel;
import com.api.magalu.model.Status;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationDTO {

    private Long id;

    @NotBlank
    private String receiver;

    @NotBlank
    private String message;

    @NotNull
    @Future
    private LocalDateTime dateTime;

    @NotNull
    private Channel channel;

    @NotNull
    private Status status;

}
