package com.dsi.book.service;

import com.dsi.book.model.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> get();
    public Author findById(int id);
    public Author save(Author author);
    public void delete(int id);
    public void update(int id, Author author);
}
