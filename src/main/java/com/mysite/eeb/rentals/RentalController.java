package com.mysite.eeb.rentals;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {

    private final RentalRepository rentalRepository;
    private final RentalService rentalService;


    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    // 대여 생성 요청 처리
    @PostMapping("/create")
    public ResponseEntity<RentalResponse> createRental(@RequestBody RentalRequestDTO rentalRequest) {
        // Rental 생성
        Rental rental = rentalService.createRental(
            rentalRequest.getOwnerPostId(),
            rentalRequest.getBorrowerPostId(),
            rentalRequest.getOwnerUsername(),
            rentalRequest.getBorrowerUsername(),
            rentalRequest.getRentalStartTime(),
            rentalRequest.getRentalEndTime(),
            rentalRequest.getStatus()  // 정수형 status
        );

        // Rental을 RentalResponse DTO로 변환
        RentalResponse response = new RentalResponse();
        response.setId(rental.getId());
        response.setOwnerPostId(rental.getOwnerPostId());
        response.setBorrowerPostId(rental.getBorrowerPostId());
        response.setOwnerUsername(rental.getOwner().getName());
        response.setBorrowerUsername(rental.getBorrower().getName());
        response.setRentalStartTime(rental.getRentalStartTime());
        response.setRentalEndTime(rental.getRentalEndTime());
        response.setStatus(rental.getStatus());
        
        // 생성된 Rental 객체 반환
        return ResponseEntity.ok(response);
    }
}
