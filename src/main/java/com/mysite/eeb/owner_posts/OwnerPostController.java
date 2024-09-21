package com.mysite.eeb.owner_posts;

import java.time.LocalDateTime;
import java.util.Map;

import com.mysite.eeb.users.UserRepository;
import com.mysite.eeb.users.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysite.eeb.users.SiteUser;

@RequiredArgsConstructor
@Controller
public class OwnerPostController {

	private final OwnerPostService ownerPostService;
	private final UserRepository userRepository;
	
	@PostMapping("/ownerPost")
	public void create(@RequestBody Map<String, Object> requestData) {
		String title = (String) requestData.get("title");
		String description = (String) requestData.get("description");
		String image_url = (String) requestData.get("image_url");
		
		SiteUser user = userRepository.findByUsername((String) requestData.get("username"));
		
		
		
		Integer cost_hour = (Integer) requestData.get("cost_hour");
		Integer cost_day =  (Integer) requestData.get("cost_day");
		Integer cost_week = (Integer) requestData.get("cost_week");
		
		LocalDateTime available_from = (LocalDateTime) requestData.get("available_from");
		LocalDateTime available_to = (LocalDateTime) requestData.get("available_to");

		this.ownerPostService.create(user, title, description, image_url, cost_hour, cost_day, cost_week, available_from, available_to);
	}
	
}