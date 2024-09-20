package com.mysite.eeb.rentals;

/**
 * 대여 개념 자체 엔티티
 */

import java.time.LocalDateTime;

import com.mysite.eeb.borrower_posts.BorrowerPost;
import com.mysite.eeb.owner_posts.OwnerPost;
import com.mysite.eeb.users.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private OwnerPost ownerPost;
	
	@ManyToOne
	private BorrowerPost borrowerPost;
	
	@ManyToOne
	private SiteUser owner;
	
	@ManyToOne
	private SiteUser borrower;
	
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	
	@Column(length = 20)
	private String status;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
}
