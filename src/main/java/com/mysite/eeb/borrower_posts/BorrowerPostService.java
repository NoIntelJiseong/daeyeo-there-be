package com.mysite.eeb.borrower_posts;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BorrowerPostService {
	private final BorrowerPostRepository borrowerPostRepository;
	
	public void create(BorrowerPost borrowerPost) {
		borrowerPost.setCreatedAt(LocalDateTime.now());
		borrowerPost.setUpdatedAt(LocalDateTime.now());
		
		borrowerPostRepository.save(borrowerPost);
	}
}
