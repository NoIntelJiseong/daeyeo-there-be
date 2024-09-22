package com.mysite.eeb.rentals;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.eeb.borrower_posts.BorrowerPostRepository;
import com.mysite.eeb.owner_posts.OwnerPostRepository;
import com.mysite.eeb.users.SiteUser;
import com.mysite.eeb.users.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final OwnerPostRepository ownerPostRepository;
    private final BorrowerPostRepository borrowerPostRepository;

    public Rental createRental(Long ownerPostId, Long borrowerPostId, String ownerUsername, String borrowerUsername, 
            LocalDateTime rentalStartTime, LocalDateTime rentalEndTime, int status) {

    	// 물주와 대여인 유저를 데이터베이스에서 가져옴
    	SiteUser owner = userRepository.findByName(ownerUsername)
    			.orElseThrow(() -> new IllegalArgumentException("Owner user not found: " + ownerUsername));

    	SiteUser borrower = userRepository.findByName(borrowerUsername)
    			.orElseThrow(() -> new IllegalArgumentException("Borrower user not found: " + borrowerUsername));

    	// Rental 엔티티 생성
    	Rental rental = new Rental();
    	rental.setOwnerPostId(ownerPostId);
    	rental.setBorrowerPostId(borrowerPostId);
    	rental.setOwner(owner);
    	rental.setBorrower(borrower);
    	rental.setRentalStartTime(rentalStartTime);
    	rental.setRentalEndTime(rentalEndTime);
    	rental.setStatus(status); // 정수형으로 대여 상태 설정

    	// Rental 엔티티 저장
    	return rentalRepository.save(rental);
    }
}
