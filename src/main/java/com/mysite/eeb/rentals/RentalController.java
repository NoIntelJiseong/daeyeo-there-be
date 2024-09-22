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
@RequestMapping("/rentals")
public class RentalController {

    private final RentalRepository rentalRepository;
    private final RentalService rentalService;


    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody RentalRequestDTO rentalRequestDTO) {
        Rental rental = rentalService.createRental(
            rentalRequestDTO.getOwnerPostId(),
            rentalRequestDTO.getBorrowerPostId(),
            rentalRequestDTO.getOwnerUsername(),
            rentalRequestDTO.getBorrowerUsername(),
            rentalRequestDTO.getRentalStartTime(),
            rentalRequestDTO.getRentalEndTime()
        );
        return ResponseEntity.ok(rental);
    }
}
