package com.ts.projekt_ts.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateResponseLoanDto {

    private long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String loanDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String endDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String returnDate;

    private long userId;

    private long bookId;

    public CreateResponseLoanDto(long id, String loanDate, String endDate, String returnDate, long userId, long bookId) {
        this.id = id;
        this.loanDate = loanDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.userId = userId;
        this.bookId = bookId;
    }

    public CreateResponseLoanDto() {}

    public long getId() {
        return id;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public long getUserId() {
        return userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

}
