package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    // Stores all books in memory
    private final List<Book> books = new ArrayList<>();

    public void save(Book book){
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(int id){
        for (Book book : books){
            if (book.getId() == id){
                return book;
            }
        }

        return null;
    }
}
