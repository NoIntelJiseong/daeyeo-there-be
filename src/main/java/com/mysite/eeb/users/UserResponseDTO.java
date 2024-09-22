package com.mysite.eeb.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
	private String username;
    private int rating;
    
    public UserResponseDTO(String username, int rating) {
        this.username = username;
        this.rating = rating;
    }
}
