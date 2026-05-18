package com.springlecture.domain.member.service;

import com.springlecture.domain.member.controller.dto.MemberRequest;
import com.springlecture.domain.member.controller.dto.MemberResponse;
import com.springlecture.domain.member.entity.MemberEntity;
import com.springlecture.domain.member.repository.MemberRepository;
import com.springlecture.global.exception.CustomException;
import com.springlecture.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberResponse save(MemberRequest request) {
        MemberEntity entity = MemberRequest.toEntity(request);
        MemberEntity savedEntity = memberRepository.save(entity);

        return MemberResponse.fromEntity(savedEntity);
    }
    public MemberResponse findById(Long memberId) {
        MemberEntity entity = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)
                );

        return MemberResponse.fromEntity(entity);
    }
}
