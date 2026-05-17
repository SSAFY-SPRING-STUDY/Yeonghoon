package com.example.study3.domain.global.exception.error.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST-001", "게시물을 불러올 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
