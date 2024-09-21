package com.mysite.eeb.users;

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
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 100)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	private Integer rating = 0; // 기본값 0
	
	private LocalDateTime crated_at;
	
	private LocalDateTime updated_at;
}
