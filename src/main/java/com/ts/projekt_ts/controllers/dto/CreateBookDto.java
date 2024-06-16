package com.ts.projekt_ts.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class CreateBookDto {

    @NotBlank(message = "Isbn is required")
    @Schema(name = "isbn", example = "123456")
    private String isbn;
    @Schema(name = "title", example = "title")
    private String title;
    @Schema(name = "author", example = "author")
    private String author;
    @Schema(name = "publisher", example = "publisher")
    private String publisher;
    @Schema(name = "publicationYear", example = "2020")
    private int publicationYear;
    @Schema(name = "availableCopies", example = "2")
    private int availableCopies;

    public CreateBookDto(String isbn, String title, String author, String publisher, int publicationYear, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
    }

    public CreateBookDto() {}

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

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

}
