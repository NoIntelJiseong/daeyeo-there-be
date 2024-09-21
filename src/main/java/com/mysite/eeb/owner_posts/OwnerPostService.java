package com.mysite.eeb.owner_posts;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OwnerPostService {
	private final OwnerPostRepository ownerPostRepository;
	
	public List<OwnerPost> getList() {
		return this.ownerPostRepository.findAll();
	}
	
	public void create(OwnerPost ownerPost) {
		ownerPost.setCreatedAt(LocalDateTime.now());
		ownerPost.setUpdatedAt(LocalDateTime.now());
		
		ownerPostRepository.save(ownerPost);
	}
	
	public OwnerPost getOwnerPostById(Long id) {
        return ownerPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OwnerPost not found with id: " + id));
    }
}
