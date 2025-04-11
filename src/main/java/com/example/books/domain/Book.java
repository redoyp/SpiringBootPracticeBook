package com.example.books.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;
}

// builder를 사용하고 싶다면 AllArgsConstructor를 없앤 뒤
// public Book(String id, String name, String author) { ... }
// 위에 @Builder 어노테이션을 붙여야 함
// 이러면 dto의 AddBookRequest에서 toEntity() 메소드 가 builder를 사용할 수 있게 됨.
// dto에서만 사용하고 싶다면 toEntity() 메소드 위에 @Builder를 붙여도 될 듯
