package com.mysite.eeb.rentals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.mysite.eeb.borrower_posts.BorrowerPost;
import com.mysite.eeb.owner_posts.OwnerPost;
import com.mysite.eeb.users.SiteUser;

@Getter
@Setter
@Entity
public class Rental {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 물주의 게시물 ID (OwnerPost)
    private Long ownerPostId;

    // 대여인의 게시물 ID (BorrowerPost)
    private Long borrowerPostId;

    // 물주의 사용자명
    @ManyToOne
    @JoinColumn(name = "owner_username", referencedColumnName = "name")
    private SiteUser owner;

    // 대여인의 사용자명
    @ManyToOne
    @JoinColumn(name = "borrower_username", referencedColumnName = "name")
    private SiteUser borrower;

    // 대여 시작 시간
    private LocalDateTime rentalStartTime;

    // 대여 종료 시간
    private LocalDateTime rentalEndTime;

    // 대여 상태
    private int status;


    // Getters, Setters, Constructors (생성자) 생략
}
