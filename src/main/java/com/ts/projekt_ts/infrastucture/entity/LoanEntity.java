package com.ts.projekt_ts.infrastucture.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loans", schema = "library_ts")
public class LoanEntity {

    /**
     * Entity representing loan.
     */

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "loanDate", nullable = false)
    private String loanDate;

    @Basic
    @Column(name = "endDate", nullable = false)
    private String endDate;

    @Basic
    @Column(name = "returnDate")
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

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

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

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

    public UserEntity getUser() {
        return user;
    }

    public BookEntity getBook() {
        return book;
    }

}
