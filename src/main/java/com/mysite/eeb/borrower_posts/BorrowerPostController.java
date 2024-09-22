package com.mysite.eeb.borrower_posts;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BorrowerPostController {

	private final BorrowerPostService borrowerPostService;
	private final BorrowerPostRepository borrowerPostRepository;
	
	
	@PostMapping("/borrowerPost")
	public ResponseEntity<String> create(@RequestBody BorrowerPost borrowerPost) {
		borrowerPostService.create(borrowerPost);
	    return ResponseEntity.ok("Borrower post created.");
	}
	
	@GetMapping("borrowerPost/search")
	public ResponseEntity<?> find(@RequestParam(value = "id") Long id) {
		Optional<BorrowerPost> borrowerPost = borrowerPostRepository.findById(id);
		
		if (!borrowerPost.isPresent()) {
			return ResponseEntity.badRequest().body("Not found");
		}
		
		return ResponseEntity.ok().body(borrowerPost);

	}
}