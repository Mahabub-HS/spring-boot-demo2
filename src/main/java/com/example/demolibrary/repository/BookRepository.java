package com.example.demolibrary.repository;

import com.example.demolibrary.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book,String> {
    Iterable<Book> findByTitle(String title);
    Iterable<Book> findByAuthor(String author);

}
