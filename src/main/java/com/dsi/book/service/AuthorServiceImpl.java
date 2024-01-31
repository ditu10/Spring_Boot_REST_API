package com.dsi.book.service;
import com.dsi.book.dao.AuthorRepository;
import com.dsi.book.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> get() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent())
            return optionalAuthor.get();
        else
            return null;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void update(int id, Author author) {
        Optional<Author> optional = authorRepository.findById(id);
        if(optional.isPresent()){
            Author a = optional.get();
            a.setName(author.getName());
            a.setCountry(author.getCountry());

            authorRepository.save(a);
        }
    }
}
