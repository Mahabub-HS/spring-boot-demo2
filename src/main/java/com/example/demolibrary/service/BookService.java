package com.example.demolibrary.service;

import com.example.demolibrary.exception.ResourceAlreadyExitsException;
import com.example.demolibrary.exception.ResourceNotFoundException;
import com.example.demolibrary.model.Book;
import com.example.demolibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);
        return bookList;
    }

    public Book findByID(String bookCode) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookCode).orElseThrow(ResourceNotFoundException::new);
        return book;
    }

    public Book findByAuthor(String author){
        return null;
    }

    public Book storeBook(Book book) throws ResourceAlreadyExitsException{

        if (bookRepository.existsById(book.getTitle())){
            throw new ResourceAlreadyExitsException();
        }else {


            Book saveBook = bookRepository.save(book);
            return saveBook;
        }
    }
}
