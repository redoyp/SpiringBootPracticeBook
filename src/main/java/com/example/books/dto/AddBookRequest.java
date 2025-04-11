package com.example.books.dto;


import com.example.books.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookRequest {
    private String id;
    private String name;
    private String author;

    public Book toEntity() {
        return new Book(id, name, author);
    }
}