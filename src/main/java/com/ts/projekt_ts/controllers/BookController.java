package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.controllers.dto.*;
import com.ts.projekt_ts.infrastucture.service.BookService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Books")
public class BookController{

    private final BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    @SecurityRequirements
    public List<GetBookDto> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/api/books/{id}")
    @SecurityRequirements
    public GetBookDto getOne(@PathVariable long id){
        return bookService.getOne(id);
    }

    @PostMapping("/api/books")
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public ResponseEntity<CreateResponseBookDto> create(@Validated @RequestBody CreateBookDto book){
        var newBook = bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PatchMapping("/api/books/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public ResponseEntity<UpdateBookResponseDto> update(@PathVariable long id, @Validated @RequestBody UpdateBookDto requestBody){
        UpdateBookResponseDto dto = bookService.update(id, requestBody);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/api/books/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
