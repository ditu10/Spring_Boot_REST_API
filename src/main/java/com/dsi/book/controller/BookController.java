package com.dsi.book.controller;

import com.dsi.book.model.Book;
import com.dsi.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// when we add the annotation @RestController instead @Controller, we don't need to write @RequestBody annotation anymore.

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


}
