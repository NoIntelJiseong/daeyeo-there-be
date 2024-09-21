package com.mysite.eeb.users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @GetMapping("/{name}")
    public ResponseEntity<SiteUser> find(@PathVariable String name) {
    	return userRepository.findByName(name)
                .map(siteUser -> ResponseEntity.ok(siteUser))  // 성공 시 200 OK와 함께 엔티티 반환
                .orElseGet(() -> ResponseEntity.notFound().build());  // 엔티티가 없을 경우 404 Not Found 반환
    }
}
    
