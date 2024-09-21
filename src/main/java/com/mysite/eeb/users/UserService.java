package com.mysite.eeb.users;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public SiteUser registerUser(SignUpRequest request) {
        if (userRepository.findByName(request.getName()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        if (!request.getPassword1().equals(request.getPassword2())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        SiteUser user = new SiteUser();
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword1()));
        user.setRating(0);  // 기본값으로 0 설정
        user.setCrated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());
        
        
        return userRepository.save(user);
    }
	
	public boolean loginUser(LoginRequest request) {
		
		
		if (!userRepository.findByName(request.getName()).isPresent()) {
			throw new IllegalArgumentException("User not found");
		}
		
        SiteUser user = (userRepository.findByName(request.getName())).get();
        // 비밀번호 비교
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return true;  // 로그인 성공
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}
