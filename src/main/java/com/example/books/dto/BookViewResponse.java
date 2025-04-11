package com.example.books.dto;

import com.example.books.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookViewResponse {
    private String id;
    private String name;
    private String author;

    public BookViewResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
    }
}
