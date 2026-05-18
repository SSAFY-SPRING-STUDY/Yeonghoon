package com.springlecture.domain.auth.service;

import com.springlecture.domain.auth.component.SessionManager;
import com.springlecture.domain.auth.controller.dto.LoginRequest;
import com.springlecture.domain.auth.controller.dto.LoginResponse;
import com.springlecture.domain.member.entity.MemberEntity;
import com.springlecture.domain.member.repository.MemberRepository;
import com.springlecture.global.exception.CustomException;
import com.springlecture.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final SessionManager sessionManager;
    private final MemberRepository memberRepository;

    public LoginResponse login(LoginRequest request) {
        MemberEntity member = memberRepository.findByloginId(request.loginId())
                .orElseThrow(() -> new CustomException(ErrorCode.LOGIN_ERROR));
        if(member.isValidPassword(request.password())){
            String token = sessionManager.createSession(member.getId());
            return new LoginResponse(token, "Bearer");
        }
        throw  new CustomException(ErrorCode.LOGIN_ERROR);
    }


    public void logout(String accessToken) {
        sessionManager.removeSession(accessToken);
    }

    public Long getMemberId(String accessToken) {
        return sessionManager.getMemberId(accessToken)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    }
}
