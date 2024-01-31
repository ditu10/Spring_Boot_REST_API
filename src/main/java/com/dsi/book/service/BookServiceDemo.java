package com.dsi.book.service;

import com.dsi.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceDemo {
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
        Book book = null;
        try{
            book = books.stream().filter(e->e.getId() == id).findFirst().get();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return book;
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }
    public Book deleteBook(int bookId){
        Optional<Book> b = books.stream().filter(book-> book.getId() == bookId).findFirst();
        if(b.isPresent()){
            books.remove(b.get());
            return b.get();
        }
        return null;
    }

    public Boolean updateBook(int id, Book b){

//        books = books.stream().peek(book->{
//            if (book.getId() == id) {
//                book.setAuthor(b.getAuthor());
//                book.setTitle(b.getTitle());
//                book.setCategory(b.getCategory());
//            }
//        }).collect(Collectors.toList());

        try{
            Book book = books.stream().filter(book1 -> book1.getId() == id).findFirst().get();
            book.setTitle(b.getTitle());
            book.setAuthor(b.getAuthor());
            book.setCategory(b.getCategory());
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
