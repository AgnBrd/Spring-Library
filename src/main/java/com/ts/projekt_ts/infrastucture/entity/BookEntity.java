package com.ts.projekt_ts.infrastucture.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books", schema = "library_ts")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "isbn", unique = true)
    private String isbn;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "author")
    private String author;

    @Basic
    @Column(name = "publisher")
    private String publisher;

    @Basic
    @Column(name = "publication_year")
    private String publication_year;

    public void setId(long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public void setAvaliable_copies(String avaliable_copies) {
        this.avaliable_copies = avaliable_copies;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public String getAvaliable_copies() {
        return avaliable_copies;
    }

    @Basic
    @Column(name = "avaliable_copies")
    private String avaliable_copies;
}
