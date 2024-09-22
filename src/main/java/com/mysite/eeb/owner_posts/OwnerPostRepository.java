package com.mysite.eeb.owner_posts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerPostRepository extends JpaRepository<OwnerPost, Long> {
	Page<OwnerPost> findAllByOrderByUpdatedAtDesc(Pageable pageable);
}
