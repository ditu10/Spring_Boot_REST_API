package com.dsi.book.service;

import com.dsi.book.dao.BookRepository;
import com.dsi.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(int bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }

    @Override
    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(int bookId, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book1 = null;
        if(optionalBook.isPresent()){
            book1 = optionalBook.get();
            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            book1.setCategory(book.getCategory());

            bookRepository.save(book1);
        }
    }

    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }
}
