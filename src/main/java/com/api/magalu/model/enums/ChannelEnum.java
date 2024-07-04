package com.api.magalu.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChannelEnum {
    EMAIL(1L, "email"),
    SMS(2L, "SMS"),
    PUSH(3L, "push"),
    WHATSAPP(4L, "whatsapp");

    private Long id;
    private String description;
}
