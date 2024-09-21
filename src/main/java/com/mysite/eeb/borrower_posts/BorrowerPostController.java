package com.mysite.eeb.borrower_posts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BorrowerPostController {

	private final BorrowerPostService borrowerPostService;
	
	@PostMapping("/borrowerPost")
	public ResponseEntity<String> create(@RequestBody BorrowerPost borrowerPost) {
		borrowerPostService.create(borrowerPost);
	    return ResponseEntity.ok("Borrower post created.");
	}
}