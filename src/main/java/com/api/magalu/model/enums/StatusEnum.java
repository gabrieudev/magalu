package com.api.magalu.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {
    SUCCESS(1L, "success"),
    PENDING(2L, "pending"),
    CANCELLED(3L, "cancelled");

    private Long id;
    private String description;
}
