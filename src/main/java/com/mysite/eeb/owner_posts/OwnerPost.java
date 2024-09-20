package com.mysite.eeb.owner_posts;

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
public class OwnerPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(length = 255)
	private String image_url;
	
	private Integer cost_hour;
	private Integer cost_day;
	private Integer cost_week;
	
	private LocalDateTime available_from;
	private LocalDateTime available_to;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	// TODO: user_id
	
}

