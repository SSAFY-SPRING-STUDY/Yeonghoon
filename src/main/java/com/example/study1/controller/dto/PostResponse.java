package com.example.study1.controller.dto;

import lombok.Getter;

@Getter
public class PostResponse {
    private final long id;
    private final String title;
    private final String content;
    private final String author;

    public PostResponse(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
