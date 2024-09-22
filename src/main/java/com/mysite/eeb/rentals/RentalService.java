package com.mysite.eeb.rentals;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.eeb.borrower_posts.BorrowerPost;
import com.mysite.eeb.borrower_posts.BorrowerPostRepository;
import com.mysite.eeb.owner_posts.OwnerPost;
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
                               LocalDateTime startTime, LocalDateTime endTime) {

        // 사용자 및 게시물 검색
        SiteUser owner = userRepository.findByName(ownerUsername)
            .orElseThrow(() -> new IllegalArgumentException("Owner not found"));
        SiteUser borrower = userRepository.findByName(borrowerUsername)
            .orElseThrow(() -> new IllegalArgumentException("Borrower not found"));

        OwnerPost ownerPost = null;
        BorrowerPost borrowerPost = null;
        
        // 게시물이 OwnerPost인지 BorrowerPost인지 확인
        if (ownerPostId != null) {
            ownerPost = ownerPostRepository.findById(ownerPostId)
                .orElseThrow(() -> new IllegalArgumentException("OwnerPost not found"));
        } else if (borrowerPostId != null) {
            borrowerPost = borrowerPostRepository.findById(borrowerPostId)
                .orElseThrow(() -> new IllegalArgumentException("BorrowerPost not found"));
        }

        // Rental 생성
        Rental rental = new Rental();
        rental.setOwnerPost(ownerPost);
        rental.setBorrowerPost(borrowerPost);
        rental.setOwner(owner);
        rental.setBorrower(borrower);
        rental.setRentalStartTime(startTime);
        rental.setRentalEndTime(endTime);
        rental.setStatus(1);

        // Rental 저장
        return rentalRepository.save(rental);
    }
}
