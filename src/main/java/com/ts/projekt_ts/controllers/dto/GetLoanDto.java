package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.infrastucture.entity.BookEntity;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;

import java.util.Date;
import java.util.Optional;

public class GetLoanDto {
    private long id;
    private long userId;
    private long bookId;

    public GetLoanDto(long id, long userId, long bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }

    public GetLoanDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

