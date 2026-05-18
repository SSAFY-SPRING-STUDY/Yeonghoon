package com.springlecture.global.handler;

import com.springlecture.domain.ApiResponse;
import com.springlecture.global.exception.CustomException;
import com.springlecture.global.exception.error.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.error(errorCode));
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ApiResponse<Void>> handleMissingHeader() {
        return ResponseEntity
                .status(ErrorCode.INVALID_PARAMETER.getStatus())
                .body(ApiResponse.error(ErrorCode.INVALID_PARAMETER));
    }

}
