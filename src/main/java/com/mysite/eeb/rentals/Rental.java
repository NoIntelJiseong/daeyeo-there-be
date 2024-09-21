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

    // 물주의 게시물 ID (OwnerPost ID와 연결)
    @ManyToOne
    @JoinColumn(name = "ownerPostId")
    private OwnerPost ownerPost;

    // 대여인의 게시물 ID (BorrowerPost ID와 연결)
    @ManyToOne
    @JoinColumn(name = "borrowerPostId")
    private BorrowerPost borrowerPost;
    
    // 물주 (Owner)
    @ManyToOne
    @JoinColumn(name = "ownerId")
    private SiteUser owner;

    // 대여인 (Borrower)
    @ManyToOne
    @JoinColumn(name = "borrowerId")
    private SiteUser borrower;

    // 대여 시작 시간
    private LocalDateTime rentalStartTime;

    // 대여 종료 시간
    private LocalDateTime rentalEndTime;

    // 대여 상태 (예: 요청 중, 대여 중, 반납 완료 등)
    private int status;

    // 생성 시간
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // 수정 시간
    @LastModifiedDate
    private LocalDateTime updatedAt;


    // Getters, Setters, Constructors (생성자) 생략
}
