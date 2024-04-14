package com.ts.projekt_ts.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UpdateLoanDto {

    @NotNull(message = "Loan date is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date loanDate;

    @NotNull(message = "End date is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date returnDate;

    private long userId;

    private long bookId;

    public UpdateLoanDto(Date loanDate, Date endDate, Date returnDate, long userId, long bookId) {
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
