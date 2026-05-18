package com.springlecture.domain.member.controller;

import com.springlecture.domain.ApiResponse;
import com.springlecture.domain.auth.service.AuthService;
import com.springlecture.domain.auth.util.AuthorizationUtils;
import com.springlecture.domain.member.controller.dto.MemberRequest;
import com.springlecture.domain.member.controller.dto.MemberResponse;
import com.springlecture.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;
    private final AuthService authService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<MemberResponse> join(@RequestBody MemberRequest request) {
        MemberResponse response = memberService.save(request);
        return ApiResponse.success(response);
    }
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<MemberResponse> me(@RequestHeader("Authorization") String authHeader) {

        String accessToken = AuthorizationUtils.getAccessToken(authHeader);
        Long memberId = authService.getMemberId(accessToken);
        MemberResponse response = memberService.findById(memberId);

        return ApiResponse.success(response);
    }

}
