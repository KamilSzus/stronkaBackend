package com.example.stronka.Service;

import com.example.stronka.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> findAll();

    Book findById(long id);
    Book save(Book book);
    Book update(Book book);
    Book deleteById(Long id);
}
