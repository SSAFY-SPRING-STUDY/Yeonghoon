package com.springlecture.domain.auth.controller;

import com.springlecture.domain.ApiResponse;
import com.springlecture.domain.auth.controller.dto.LoginRequest;
import com.springlecture.domain.auth.controller.dto.LoginResponse;
import com.springlecture.domain.auth.service.AuthService;
import com.springlecture.domain.auth.util.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ApiResponse.success(response);

    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> logout(@RequestHeader("Authorization") String authHeader){

        // authHeader = "token" x
        // authHeader = "BEARER aaLskdjflkasjdl;kfasdfl;k"

        String accessToken = AuthorizationUtils.getAccessToken(authHeader);

        authService.logout(accessToken);

        return ApiResponse.success();
    }
}
