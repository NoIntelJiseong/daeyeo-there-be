package com.mysite.eeb.borrower_posts;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.eeb.users.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BorrowerPostService {
	private final BorrowerPostRepository borrowerPostRepository;
	
	public void create(SiteUser user, String title, String description, LocalDateTime preferred_time_from, LocalDateTime preferred_time_to) {
		BorrowerPost b = new BorrowerPost();
		
		b.setUser(user);
		
		b.setTitle(title);
		b.setDescription(description);
		
		b.setPreferred_time_from(preferred_time_from);
		b.setPreferred_time_to(preferred_time_to);
		
		this.borrowerPostRepository.save(b);
	}
}
