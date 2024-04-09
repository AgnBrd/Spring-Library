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
    @Column(name = "isbn", unique = true, nullable = false)
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
    @Column(name = "publicationYear")
    private int publicationYear;

    @Basic
    @Column(name = "avaliableCopies")
    private int avaliableCopies;

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

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = Integer.parseInt(publicationYear);
    }

    public void setAvaliableCopies(String avaliableCopies) {
        this.avaliableCopies = Integer.parseInt(avaliableCopies);
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getAvaliableCopies() {
        return avaliableCopies;
    }

}
