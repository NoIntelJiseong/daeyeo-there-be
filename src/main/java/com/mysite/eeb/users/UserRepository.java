package com.mysite.eeb.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	boolean existByUsername(String username);
	SiteUser findByUsername(String username);
}
