package com.dsi.book.service;

import com.dsi.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private static List<Book> books = new ArrayList<>();

    static{
        books.add(new Book(1,"Java Complete Reference", "Bozlur Rahman", "Educative"));
        books.add(new Book(2,"Harry Porter", "J.K. Rowling", "Drama"));
        books.add(new Book(3,"Twilight", "Stephenie Meyer", "Fiction"));
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id){

        Optional<Book> opt = books.stream().filter(e->e.getId() == id).findFirst();
        if (opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }

}
