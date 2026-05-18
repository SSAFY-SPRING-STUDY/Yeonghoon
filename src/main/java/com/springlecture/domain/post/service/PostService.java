package com.springlecture.domain.post.service;

import com.springlecture.domain.member.controller.dto.MemberResponse;
import com.springlecture.domain.member.service.MemberService;
import com.springlecture.domain.post.controller.dto.PostRequest;
import com.springlecture.domain.post.controller.dto.PostResponse;
import com.springlecture.domain.post.PostEntity;
import com.springlecture.domain.post.repository.PostRepository;
import com.springlecture.global.exception.CustomException;
import com.springlecture.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;



    public PostResponse save(PostRequest postRequest, Long authorId) {
        PostEntity entity = PostRequest.toEntity(postRequest, authorId);
        PostEntity savedEntity = postRepository.save(entity);
        MemberResponse memberResponse = memberService.findById(authorId);
        PostResponse response = PostResponse.fromEntity(savedEntity, memberResponse);
            return response;
    }
    public List<PostResponse> findAll() {
        List<PostEntity> entityList = postRepository.findAll();
        List<PostResponse> responseList = new ArrayList<>();

        for(PostEntity entity : entityList){
            MemberResponse memberResponse = memberService.findById(entity.getAuthorId());
            PostResponse response = PostResponse.fromEntity(entity, memberResponse);
            responseList.add(response);
        }
        return responseList;
    }

    public PostResponse findById(Long id)
    {
        PostEntity foundEntity = postRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        MemberResponse memberResponse = memberService.findById(foundEntity.getAuthorId());
        PostResponse response = PostResponse.fromEntity(foundEntity, memberResponse);

        return response;
    }

    public void update(Long id, PostRequest request) {
        postRepository.update(id, request);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
