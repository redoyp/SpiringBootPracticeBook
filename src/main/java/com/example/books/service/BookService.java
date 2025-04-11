package com.example.books.service;

import com.example.books.domain.Book;
import com.example.books.dto.AddBookRequest;
import com.example.books.repository.BookRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 책 목록 전체 조회
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 책 정보 저장
    public Book saveBook(AddBookRequest request) {
        Book book = request.toEntity();
        return bookRepository.save(book);
    }

    // 책 정보 단건 조회
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("No exists id: " + id));
    }
}
