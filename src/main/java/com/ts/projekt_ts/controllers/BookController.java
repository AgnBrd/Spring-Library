package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.infrastucture.entity.BookEntity;
import com.ts.projekt_ts.infrastucture.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController{
    private final BookService bookService;
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping
    public List<BookEntity> getAllBooks(){
        return bookService.getAll();
    }
    @GetMapping("/{id}")
    public BookEntity getOne(@PathVariable long id){
        return bookService.getOne(id);
    }
    @PostMapping
    public BookEntity create(@RequestBody BookEntity book){
        return bookService.create(book);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        bookService.delete(id);
    }
}
