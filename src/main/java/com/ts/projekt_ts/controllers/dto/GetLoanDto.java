package com.ts.projekt_ts.controllers.dto;

public class GetLoanDto {
    private long id;
    private String loan_date;
    private String end_date;
    private String return_date;
    private long userId;
    private long bookId;

    public GetLoanDto(long id, String loan_date, String end_date, String return_date, long userId, long bookId) {
        this.id = id;
        this.loan_date = loan_date;
        this.end_date = end_date;
        this.return_date = return_date;
        this.userId = userId;
        this.bookId = bookId;
    }

    public GetLoanDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(String loan_date) {
        this.loan_date = loan_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
