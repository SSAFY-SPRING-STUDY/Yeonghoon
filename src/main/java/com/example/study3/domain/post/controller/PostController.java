package com.example.study3.domain.post.controller;

import com.example.study3.domain.post.controller.dto.PostRequest;
import com.example.study3.domain.post.controller.dto.PostResponse;
import com.example.study3.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    // 게시글 생성
    @PostMapping()
    public PostResponse createPost(@RequestBody PostRequest request) {
        System.out.println(request);

        PostResponse response = postService.save(request);
            return response;

    }
    @GetMapping()
    public List<PostResponse> findAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostResponse findPostById(@PathVariable Long id){
        PostResponse response = null;
        try{
            response = postService.findById(id);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return response;
    }
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequest request){
        postService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deleteById(id);
    }

}
