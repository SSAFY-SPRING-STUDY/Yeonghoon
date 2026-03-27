package com.example.study1.controller.dto;

import org.springframework.stereotype.Component;

@Component
class CreatePostRequest {
    public String title;
    public String content;
    public String author;

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
