package com.mysite.eeb.owner_posts;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.eeb.users.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OwnerPostService {
	private final OwnerPostRepository ownerPostRepository;
	
	public List<OwnerPost> getList() {
		return this.ownerPostRepository.findAll();
	}
	
	public void create(SiteUser user, String title, String description, String image_url, Integer cost_hour, Integer cost_day, Integer cost_week, LocalDateTime available_from, LocalDateTime available_to) {
		OwnerPost o = new OwnerPost();
		
		o.setUser(user);
		
		o.setTitle(title);
		o.setDescription(description);
		
		o.setImage_url(image_url);
		
		o.setCost_hour(cost_hour);
		o.setCost_day(cost_day);
		o.setCost_week(cost_week);
		
		
		o.setAvailable_from(available_from);
		o.setAvailable_to(available_to);
		
		this.ownerPostRepository.save(o);	
	}
}
