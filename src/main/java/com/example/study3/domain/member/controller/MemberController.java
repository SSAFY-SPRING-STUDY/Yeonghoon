package com.example.study3.domain.member.controller;

import com.example.study3.domain.auth.service.AuthService;
import com.example.study3.domain.auth.util.AuthorizationUtils;
import com.example.study3.domain.member.controller.dto.MemberRequest;
import com.example.study3.domain.member.controller.dto.MemberResponse;
import com.example.study3.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;
    private final AuthService authService;

    @PostMapping()
    public ResponseEntity<MemberResponse> join(@RequestBody MemberRequest request) {
        MemberResponse response = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public MemberResponse me(@RequestHeader("Authorization") String authHeader) {

        String accessToken = AuthorizationUtils.getAccessToken(authHeader);
        Long memberId = authService.getMemberId(accessToken);
        MemberResponse response = memberService.findById(memberId);

        return response;
    }

}
