package com.springlecture.domain.post.controller.dto;

import com.springlecture.domain.post.PostEntity;
import lombok.Getter;

@Getter
public class PostRequest {
    private final String title;
    private final String content;
    private final String author;


    public PostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static PostEntity toEntity(PostRequest postRequest, Long authorId) {
        return new PostEntity(postRequest.getTitle(), postRequest.getContent(), authorId);
    }
}
