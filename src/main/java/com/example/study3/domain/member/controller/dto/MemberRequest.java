package com.example.study3.domain.member.controller.dto;

import com.example.study3.domain.member.entity.MemberEntity;

public record MemberRequest(
        String loginId,
        String password,
        String name

){
    public static MemberEntity toEntity(MemberRequest request){
        return new MemberEntity(
                request.loginId(),
                request.password(),
                request.name()
        );
    }
}
