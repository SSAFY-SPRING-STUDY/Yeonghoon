package com.example.study1.repository;

import com.example.study1.controller.dto.PostRequest;
import com.example.study1.entity.PostEntity;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    List<PostEntity> postList = new ArrayList<>();

    public PostEntity save(PostEntity postEntity){
        postList.add(postEntity);

        return postEntity;
    }
    public List<PostEntity> findAll(){
        return postList;
    };

    public Optional<PostEntity> findById(Long id) {
        for(PostEntity entity : postList) {
            if(entity.getId().equals(id)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    public void update(Long id, PostRequest request) {
        Optional<PostEntity> entity = findById(id);

        if(entity.isPresent()){
        entity.get().modify(request.getTitle(), request.getContent());

        }


    }

    public void deleteById(Long id) {
        Optional<PostEntity> entity = findById(id);

        if(entity.isPresent()){
            postList.remove(entity.get());
        }
    }

//    public Optional<PostEntity> findById(Long id);
}
