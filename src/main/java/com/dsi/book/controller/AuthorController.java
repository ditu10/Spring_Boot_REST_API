package com.dsi.book.controller;

import com.dsi.book.model.Author;
import com.dsi.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> authorList = authorService.get();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") int authorId){
        Author author = authorService.findById(authorId);
        if(author != null)
            return new ResponseEntity<>(author, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        Author a = authorService.save(author);
        if(a!=null)
            return new ResponseEntity<>(a,HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable("id") int authorId){
        authorService.delete(authorId);
    }

    @PutMapping("/authors/{id}")
    public void updateAuthor(@PathVariable("id") int authorId, @RequestBody Author author){
        authorService.update(authorId,author);
    }

}
