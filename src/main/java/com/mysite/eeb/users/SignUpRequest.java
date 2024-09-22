package com.mysite.eeb.users;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class SignUpRequest {
	private String name;
	private String password1;
	private String password2;
}
