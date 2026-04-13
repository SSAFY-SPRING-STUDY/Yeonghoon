package com.example.study3.domain.member.service;

import com.example.study3.domain.member.controller.dto.MemberRequest;
import com.example.study3.domain.member.controller.dto.MemberResponse;
import com.example.study3.domain.member.entity.MemberEntity;
import com.example.study3.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberResponse save(MemberRequest request) {
        MemberEntity entity = MemberRequest.toEntity(request);

    }
}
