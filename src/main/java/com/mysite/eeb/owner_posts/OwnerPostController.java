package com.mysite.eeb.owner_posts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysite.eeb.users.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OwnerPostController {

	private final OwnerPostService ownerPostService;
	
	@PostMapping("/ownerPost")
	public ResponseEntity<String> create(@RequestBody OwnerPost ownerPost) {
		ownerPostService.create(ownerPost);
	    return ResponseEntity.ok("Owner post created.");
	}
}