package com.example.books.controller;

import com.example.books.dto.AddBookRequest;
import com.example.books.dto.BookViewResponse;
import com.example.books.domain.Book;
import com.example.books.service.BookService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 책 전체 조회
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BookViewResponse> books = bookService.getAllBooks().stream()
                .map(BookViewResponse::new)
                .toList();
        model.addAttribute("books", books);

        return "bookManage";
    }

    // 책 단건 조회
    // = @RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable("id") String id, Model model) {
        Book book = bookService.getBookById(id);

        model.addAttribute("book", new BookViewResponse(book));

        return "bookDetail";
    }

    // 책 단건 저장
    // = @RequestMapping(method = RequestMethod.POST, value = "/books")
    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") AddBookRequest request) {
        bookService.saveBook(request);

        return "redirect:/books";
    }

}
