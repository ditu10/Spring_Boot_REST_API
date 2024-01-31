package com.dsi.book.service;

import com.dsi.book.model.Author;
import com.dsi.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceDemo {
    private static List<Book> books = new ArrayList<>();

    static{
        Author a1 = new Author(1,"Bozlur Rahman","Bangladesh");
        Author a2 = new Author(2,"Jafor Iqbal","Bangladesh");
        Author a3 = new Author(3,"Stephen Hawking" ,"USA");

        books.add(new Book(1,"Java Complete Reference", a1, "Educative"));
        books.add(new Book(2,"Tuntuni o Chotacchu", a2, "Drama"));
        books.add(new Book(3,"Big Bang Theory", a3, "Fiction"));
    }

    public List<Book> getAllBooks(){
        System.out.println(books.get(1));
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
