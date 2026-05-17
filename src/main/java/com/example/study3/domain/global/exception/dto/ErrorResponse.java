package com.example.study3.domain.global.exception.dto;

public record ErrorResponse(
        String code,
        String message
) {
}
