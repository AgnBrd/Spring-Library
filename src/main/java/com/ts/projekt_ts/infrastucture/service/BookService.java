package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.controllers.dto.CreateBookDto;
import com.ts.projekt_ts.controllers.dto.CreateResponseBookDto;
import com.ts.projekt_ts.controllers.dto.GetBookDto;
import com.ts.projekt_ts.infrastucture.entity.BookEntity;
import com.ts.projekt_ts.infrastucture.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<GetBookDto> getAll(){
        var books =  bookRepository.findAll();
        return books.stream().map((book) -> new GetBookDto(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublicationYear(), book.getAvaliableCopies() > 0)).collect(Collectors.toList());
    }
    public GetBookDto getOne(long id){
        var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return new GetBookDto(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPublicationYear(), book.getAvaliableCopies() > 0);
    }

    public CreateResponseBookDto create(CreateBookDto book){
        var bookEntity = new BookEntity();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setPublicationYear(String.valueOf(book.getPublicationYear()));
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setAvaliableCopies(String.valueOf(book.getAvaliableCopies()));
        var newBook = bookRepository.save(bookEntity);
        return new CreateResponseBookDto(newBook.getId(), newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), newBook.getPublicationYear(), newBook.getAvaliableCopies());
    }
    public void delete(long id){
        if(!bookRepository.existsById(id)){
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }

}
