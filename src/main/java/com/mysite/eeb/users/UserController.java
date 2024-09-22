package com.mysite.eeb.users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
        try {
            userService.registerUser(signUpRequest);
            return ResponseEntity.ok("User registered successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isLoginSuccessful = userService.loginUser(loginRequest);
            if (isLoginSuccessful) {
                return ResponseEntity.ok("Login successful.");
            } else {
                return ResponseEntity.badRequest().body("Login failed.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> getUserByUsername(@RequestParam("name") String name) {
    	SiteUser user = userRepository.findByName(name)
    			.orElseThrow(() -> new IllegalArgumentException("User not found with username: " + name));
    	
    	UserResponseDTO responseDTO = new UserResponseDTO(user.getName(), user.getRating());

        return ResponseEntity.ok(responseDTO);
    }
    
    @PostMapping("/raitingUp")
    public ResponseEntity<String> upRaiting(@RequestBody SiteUser user) {
    	SiteUser u = userRepository.findByName(user.getName()).get();
    	u.setRating(u.getRating() + 10);
    	userRepository.save(u);
    	return ResponseEntity.ok("");
    }
    
    @PostMapping("/raitingDown")
    public ResponseEntity<String> downRaiting(@RequestBody SiteUser user) {
    	SiteUser u = userRepository.findByName(user.getName()).get();
    	u.setRating(u.getRating() - 10);
    	userRepository.save(u);
    	return ResponseEntity.ok("");
    }
}
    
