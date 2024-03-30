package com.ts.projekt_ts.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("api/books")
    public String getAllBooks(){
        return "All books";
    }
}
