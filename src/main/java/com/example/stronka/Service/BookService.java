package com.example.stronka.Service;

import com.example.stronka.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookService extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String title);

}
