package com.mysite.eeb;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public PageResponse<PostResponseDto> getAllPosts() {
        return postService.getAllPosts(0, 10);
    }
}

