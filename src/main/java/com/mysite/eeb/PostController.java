package com.mysite.eeb;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public PageResponse<PostResponseDto> getAllPosts(
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size) {
        return postService.getAllPosts(page, size);
    }
}
