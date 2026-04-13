package com.example.study3.domain.auth.controller.dto;

public record LoginRequest(
        String loginId,
        String password
) {
}
