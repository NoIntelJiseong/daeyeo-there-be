package com.mysite.eeb.borrower_posts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerPostRepository extends JpaRepository<BorrowerPost, Long> {
	Page<BorrowerPost> findAllByOrderByUpdatedAtDesc(Pageable pageable);
}