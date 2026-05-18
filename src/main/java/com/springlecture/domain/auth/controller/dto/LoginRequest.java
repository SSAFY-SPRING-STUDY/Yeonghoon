package com.springlecture.domain.auth.controller.dto;

public record LoginRequest(
        String loginId,
        String password
) {
}
