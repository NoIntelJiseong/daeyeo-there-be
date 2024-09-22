package com.mysite.eeb;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.eeb.owner_posts.OwnerPost;
import com.mysite.eeb.owner_posts.OwnerPostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final OwnerPostRepository ownerPostRepository;

    @GetMapping("ownerPost/all")
    public PageResponse<PostResponseDto> getAllPosts() {
        return postService.getAllPosts(0, 10);
    }
    
    @GetMapping("ownerPost/search")
	public ResponseEntity<?> find(@RequestParam(value = "id") Long id) {
		Optional<OwnerPost> ownerPost = ownerPostRepository.findById(id);
		
		if (!ownerPost.isPresent()) {
			return ResponseEntity.badRequest().body("Not found");
		}
		
		return ResponseEntity.ok().body(ownerPost);
    }
}

