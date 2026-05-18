package com.springlecture.domain.post.controller.dto;

import com.springlecture.domain.member.controller.dto.MemberResponse;
import com.springlecture.domain.post.PostEntity;


public record PostResponse(
        Long id,
        String title,
        String content,
        MemberResponse memberInfo
) {

    public static PostResponse fromEntity(PostEntity entity, MemberResponse memberResponse){
        return new PostResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                memberResponse
        );
    }
}
