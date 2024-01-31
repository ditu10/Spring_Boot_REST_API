package com.dsi.book.service;

import com.dsi.book.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book findBookById(int bookId);
    public void deleteBookById(int bookId);
    public void updateBook(int bookId, Book book);
    public Book addBook(Book book);
}
