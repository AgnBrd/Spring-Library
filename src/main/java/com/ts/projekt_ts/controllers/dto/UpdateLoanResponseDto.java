package com.ts.projekt_ts.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UpdateLoanResponseDto {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date loanDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date returnDate;

    private long userId;

    private long bookId;

    public UpdateLoanResponseDto(Date loanDate, Date endDate, Date returnDate, long userId, long bookId) {
        this.loanDate = loanDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.userId = userId;
        this.bookId = bookId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public long getUserId() {
        return userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

}
