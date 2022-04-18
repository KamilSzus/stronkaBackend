//package com.example.stronka.Service.implementation;
//
//import com.example.stronka.temp.Book;
//import com.example.stronka.Service.BookService;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class BookServiceImplementation implements BookService {
//
//    private Long bookId = 100L;
//    private final Map<Long, Book> bookMap = new HashMap<>();
//
//    @Override
//    public Collection<Book> findAll() {
//        return bookMap.values();
//    }
//
//    @Override
//    public Book findById(long id) {
//        return bookMap.get(id);
//    }
//
//    @Override
//    public Book save(Book book) {
//        Long newBookId = ++bookId;
//        book.setId(newBookId);
//        bookMap.put(newBookId, book);
//        return bookMap.get(newBookId);
//    }
//
//    @Override
//    public Book update(Book book) {
//        bookId = book.getId();
//        if (bookMap.get(bookId) != null) {
//            return bookMap.get(bookId);
//        }
//        return null;
//    }
//
//    @Override
//    public Book deleteById(Long id) {
//        return bookMap.remove(id);
//    }
//}
