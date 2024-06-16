package com.ts.projekt_ts.controllers.dto;

public class GetBookDto {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private boolean isAvailable;

    public GetBookDto(long id, String isbn, String title, String author, String publisher, int publicationYear, boolean isAvailable) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
    }

    public GetBookDto() {}

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

    public boolean getIsAvailable() {
        return isAvailable;
    }

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

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

}
