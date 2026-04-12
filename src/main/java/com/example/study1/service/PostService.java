package com.example.study1.service;

import com.example.study1.controller.dto.PostRequest;
import com.example.study1.controller.dto.PostResponse;
import com.example.study1.entity.PostEntity;
import com.example.study1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;




    public PostResponse save(PostRequest request) {
        PostEntity entity = new PostEntity(request.getTitle(), request.getContent(), request.getAuthor());
        PostEntity savedEntity = postRepository.save(entity);

        PostResponse response = PostResponse.fromEntity(savedEntity);
            return response;
    }
    public List<PostResponse> findAll() {
        List<PostEntity> entityList = postRepository.findAll();
        List<PostResponse> responseList = new ArrayList<>();

        for(PostEntity entity : entityList){
            PostResponse response = PostResponse.fromEntity(entity);
            responseList.add(response);
        }
        return responseList;
    }

    public PostResponse findById(Long id)
    {
        PostEntity foundEntity = postRepository.findById(id).orElseThrow(() -> new RuntimeException("ID값에 맞는 게시물이 존재하지 않습니다."));
        PostResponse response = PostResponse.fromEntity(foundEntity);

        return response;
    }

    public void update(Long id, PostRequest request) {
        postRepository.update(id, request);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
