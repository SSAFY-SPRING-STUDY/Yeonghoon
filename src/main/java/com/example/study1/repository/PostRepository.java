package com.example.study1.repository;

import com.example.study1.entity.PostEntity;
import org.springframework.stereotype.Repository;
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
//    public Optional<PostEntity> findById(Long id);
}
