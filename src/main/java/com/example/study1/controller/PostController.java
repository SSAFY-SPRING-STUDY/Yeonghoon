package com.example.study1.controller;

import com.example.study1.service.PostService;
import com.example.study1.controller.dto.PostRequest;
import com.example.study1.controller.dto.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 생성
    @PostMapping("/api/posts")
    public PostResponse createPost(@RequestBody PostRequest request) {
        System.out.println(request);

        PostResponse response = postService.save(request);
            return response;

    }
    @GetMapping("/api/posts")
    public List<PostResponse> findAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/api/posts/{id}")
    public PostResponse findPostById(@PathVariable long id){
        PostResponse response =  postService.findByID(id);
    }
}
