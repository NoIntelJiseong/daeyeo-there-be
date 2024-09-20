package com.mysite.eeb.rentals;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	
	@Column(length = 20)
	private String status;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	//TODO: owner_post_id, borrower_post_id, owner_id, borrower_id
}
