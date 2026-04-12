package com.example.study1.controller.dto;

import com.example.study1.entity.PostEntity;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public class PostRequest {
    private final String title;
    private final String content;
    private final String author;


    public PostRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static PostEntity toEntity(PostRequest postRequest) {
        return new PostEntity(postRequest.getTitle(), postRequest.getContent(), postRequest.getAuthor());
    }
}
