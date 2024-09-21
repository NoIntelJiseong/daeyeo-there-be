package com.mysite.eeb.borrower_posts;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.eeb.users.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BorrowerPostService {
	private final BorrowerPostRepository borrowerPostRepository;
	
}
