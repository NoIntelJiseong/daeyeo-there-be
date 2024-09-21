package com.mysite.eeb;

import java.time.LocalDateTime;

import com.mysite.eeb.borrower_posts.BorrowerPost;
import com.mysite.eeb.owner_posts.OwnerPost;

public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private String postType;  // "owner" 또는 "borrower"로 엔티티 구분
    
    // BorrowerPost 전용 필드
    private LocalDateTime preferredTimeFrom;
    private LocalDateTime preferredTimeTo;
    
    // OwnerPost 전용 필드
    private String imageUrl;
    private Integer costHour;
    private Integer costDay;
    private Integer costWeek;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Constructor for BorrowerPost
    public PostResponseDto(BorrowerPost borrowerPost) {
        this.id = borrowerPost.getId();
        this.title = borrowerPost.getTitle();
        this.description = borrowerPost.getDescription();
        this.postType = "borrower";
        this.preferredTimeFrom = borrowerPost.getPreferred_time_from();
        this.preferredTimeTo = borrowerPost.getPreferred_time_to();
        this.createdAt = borrowerPost.getCreated_at();
        this.updatedAt = borrowerPost.getUpdated_at();
    }

    // Constructor for OwnerPost
    public PostResponseDto(OwnerPost ownerPost) {
        this.id = ownerPost.getId();
        this.title = ownerPost.getTitle();
        this.description = ownerPost.getDescription();
        this.postType = "owner";
        this.imageUrl = ownerPost.getImage_url();
        this.costHour = ownerPost.getCost_hour();
        this.costDay = ownerPost.getCost_day();
        this.costWeek = ownerPost.getCost_week();
        this.availableFrom = ownerPost.getAvailable_from();
        this.availableTo = ownerPost.getAvailable_to();
        this.createdAt = ownerPost.getCreated_at();
        this.updatedAt = ownerPost.getUpdated_at();
    }
}
