package com.mysite.eeb;

import java.util.List;

public class PageResponse<T> {
    private List<T> content;        // 실제 데이터 목록
    private int currentPage;        // 현재 페이지 번호
    private int pageSize;           // 페이지당 항목 수
    private int totalPages;         // 총 페이지 수
    private long totalElements;     // 전체 데이터 수

    public PageResponse(List<T> content, int currentPage, int pageSize, int totalPages, long totalElements) {
        this.content = content;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    // Getter 및 Setter
}
