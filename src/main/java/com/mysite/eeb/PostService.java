package com.mysite.eeb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.eeb.borrower_posts.BorrowerPost;
import com.mysite.eeb.borrower_posts.BorrowerPostRepository;
import com.mysite.eeb.owner_posts.OwnerPost;
import com.mysite.eeb.owner_posts.OwnerPostRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final OwnerPostRepository ownerPostRepository;
    private final BorrowerPostRepository borrowerPostRepository;

    public PageResponse<PostResponseDto> getAllPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        
        // OwnerPost와 BorrowerPost 각각 페이징
        Page<OwnerPost> ownerPostsPage = ownerPostRepository.findAllByOrderByUpdatedAtDesc(pageable);
        Page<BorrowerPost> borrowerPostsPage = borrowerPostRepository.findAllByOrderByUpdatedAtDesc(pageable);

        // DTO로 변환하여 합침
        List<PostResponseDto> combinedPosts = new ArrayList<>();
        ownerPostsPage.getContent().forEach(ownerPost -> combinedPosts.add(new PostResponseDto(ownerPost)));
        borrowerPostsPage.getContent().forEach(borrowerPost -> combinedPosts.add(new PostResponseDto(borrowerPost)));

        // totalElements와 totalPages는 합쳐서 계산
        long totalElements = ownerPostsPage.getTotalElements() + borrowerPostsPage.getTotalElements();
        int totalPages = Math.max(ownerPostsPage.getTotalPages(), borrowerPostsPage.getTotalPages());

        return new PageResponse<>(combinedPosts, page, size, totalPages, totalElements);
    }
}
