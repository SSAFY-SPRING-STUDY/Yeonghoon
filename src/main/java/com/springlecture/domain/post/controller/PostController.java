package com.springlecture.domain.post.controller;

import com.springlecture.domain.ApiResponse;
import com.springlecture.domain.auth.service.AuthService;
import com.springlecture.domain.auth.util.AuthorizationUtils;
import com.springlecture.domain.post.controller.dto.PostRequest;
import com.springlecture.domain.post.controller.dto.PostResponse;
import com.springlecture.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final AuthService authService;

    // 게시글 생성
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PostResponse> createPost(@RequestBody PostRequest postRequest, @RequestHeader("Authorization") String authHeader) {
        String token = AuthorizationUtils.getAccessToken(authHeader);
        Long memberId = authService.getMemberId(token);
        PostResponse response = postService.save(postRequest, memberId);
            return ApiResponse.success(response);

    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<PostResponse>> findAllPosts() {
        return ApiResponse.success(postService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponse> findPostById(@PathVariable Long id){
        PostResponse response = postService.findById(id);

        return ApiResponse.success(response);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> updatePost(@PathVariable Long id, @RequestBody PostRequest request){
        postService.update(id, request);
        return ApiResponse.success();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deletePost(@PathVariable Long id){
        postService.deleteById(id);
        return ApiResponse.success();
    }

}
