package com.example.study3.domain.global.exception.error.handler;

import com.example.study3.domain.global.exception.CustomException;
import org.springframework.http.ResponseEntity;
import com.example.study3.domain.global.exception.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body();
    }
}
