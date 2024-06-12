package com.ts.projekt_ts.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CreateLoanDto {

    @NotNull(message = "Loan date is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Schema(name = "loanDate", example = "2023-12-12")
    private String loanDate;

    @NotNull(message = "End date is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Schema(name = "endDate", example = "2024-02-04")
    private String endDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Schema(name = "returnDate", example = "2024-01-30")
    private String returnDate;
    @Schema(name = "userId", example = "1")
    private long userId;
    @Schema(name = "bookId", example = "1")
    private long bookId;

    public CreateLoanDto() {}

    public CreateLoanDto(String loanDate, String endDate, String returnDate, long userId, long bookId) {
        this.loanDate = loanDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.userId = userId;
        this.bookId = bookId;
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
