package com.ts.projekt_ts.controllers.dto;

public class CreateResponseDto {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int avaliableCopies;

    public CreateResponseDto(long id, String isbn, String title, String author, String publisher, int publicationYear, int avaliableCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.avaliableCopies = avaliableCopies;
    }

    public CreateResponseDto() {
    }
    public long getId(){
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

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvaliableCopies(int avaliableCopies) {
        this.avaliableCopies = avaliableCopies;
    }
}

