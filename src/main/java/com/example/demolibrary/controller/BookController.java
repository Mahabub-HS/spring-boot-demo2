package com.example.demolibrary.controller;

import com.example.demolibrary.exception.ResourceAlreadyExitsException;
import com.example.demolibrary.exception.ResourceNotFoundException;
import com.example.demolibrary.model.Book;
import com.example.demolibrary.repository.BookRepository;
import com.example.demolibrary.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
}


    @GetMapping("/book")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> bookList = bookService.findAll();
        return ResponseEntity.ok(bookList);

    }

    @GetMapping("/{bookCode}")
    public ResponseEntity<Book>findByBookCode(@PathVariable String bookCode){
        try {
             Book book = bookService.findByID(bookCode);
             return ResponseEntity.ok(book);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/store")
    public ResponseEntity<Book> storeBook(@RequestBody Book book){
        try {
            Book storeBook = bookService.storeBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(storeBook);
        } catch (ResourceAlreadyExitsException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
