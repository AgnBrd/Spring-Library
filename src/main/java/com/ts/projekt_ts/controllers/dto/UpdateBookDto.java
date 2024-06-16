package com.ts.projekt_ts.controllers.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateBookDto {

    @NotBlank(message = "Isbn is required")
    private String isbn;

    private String title;

    private String author;

    private String publisher;

    private int publicationYear;

    private int availableCopies;

    public UpdateBookDto(String isbn, String title, String author, String publisher, int publicationYear, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
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

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setIsbn(String isbn) { this.isbn = isbn; }

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

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

}
