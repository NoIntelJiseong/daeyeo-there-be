package com.mysite.eeb.rentals;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalRequestDTO {
	private Long ownerPostId;
    private Long borrowerPostId;
    private String ownerUsername;
    private String borrowerUsername;
    private LocalDateTime rentalStartTime;
    private LocalDateTime rentalEndTime;
    private int status;  // 정수형 status
}
