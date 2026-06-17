package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.exception.BookNotFoundException;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.util.FileUtil;

import java.util.List;

public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        this.books = FileUtil.read();
    }

    public void save(Book book) {
        books.add(book);
        FileUtil.write(books);
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        throw new BookNotFoundException("Book not found with id: " + id);
    }
}