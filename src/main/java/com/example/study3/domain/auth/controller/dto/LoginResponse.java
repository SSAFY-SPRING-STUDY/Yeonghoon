package com.example.study3.domain.auth.controller.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
