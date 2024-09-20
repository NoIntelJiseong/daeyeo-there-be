package com.mysite.eeb.borrower_posts;

import java.time.LocalDateTime;

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
public class BorrowerPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne
	private SiteUser user;
	
	private LocalDateTime created_at;
	
	// TODO: user_id, preferred_time_from, preferred_time_to, update_at
}
