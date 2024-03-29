package com.dsi.book.controller;

import com.dsi.book.model.Book;
import com.dsi.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> bookList = bookService.getAllBooks();
        if(bookList.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int bookId){
        Book book = bookService.findBookById(bookId);
        if(book == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b;
        try{
            b = bookService.addBook(book);
            return new ResponseEntity<>(b,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable("bookId") int id){
        bookService.updateBook(id, book);
        return new ResponseEntity<>("Book updated successfully",HttpStatus.CREATED);
    }
}
