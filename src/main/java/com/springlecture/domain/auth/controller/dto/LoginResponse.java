package com.springlecture.domain.auth.controller.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
