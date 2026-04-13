package com.example.study3.domain.member.controller.dto;

import com.example.study3.domain.member.entity.MemberEntity;

import java.lang.reflect.Member;

public record MemberResponse(
        Long id,
        String loginId,
        String name
) {
    public static MemberResponse fromEntity(MemberEntity entity) {
        return new MemberResponse(
                entity.getId(),
                entity.getLoginId(),
                entity.getName()
        );
    }
}
