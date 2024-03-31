package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.controllers.dto.CreateBookDto;
import com.ts.projekt_ts.controllers.dto.CreateResponseDto;
import com.ts.projekt_ts.controllers.dto.GetBookDto;
import com.ts.projekt_ts.infrastucture.entity.BookEntity;
import com.ts.projekt_ts.infrastucture.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.CacheResponse;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController{
    private final BookService bookService;
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping
    public List<GetBookDto> getAllBooks(){
        return bookService.getAll();
    }
    @GetMapping("/{id}")
    public GetBookDto getOne(@PathVariable long id){
        return bookService.getOne(id);
    }
    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@RequestBody CreateBookDto book){
        var newBook = bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
