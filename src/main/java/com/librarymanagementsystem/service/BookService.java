package com.librarymanagementsystem.service;

import com.librarymanagementsystem.dto.ApiResponse;
import com.librarymanagementsystem.exception.GlobalExceptionHandler;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.util.ValidationUtil;

public class BookService {

    // Create one BookRepository object and keep using it inside this class.
    private final BookRepository repository =
            new BookRepository();

    public void addBook(Book book){
        ValidationUtil.validateId(
                book.getId()
        );

        ValidationUtil.validateBookTitle(
                book.getTitle()
        );

        ValidationUtil.validateAuthor(
                book.getAuthor()
        );

        repository.save(book);
    }

    public void displayBooks(){
        for (Book book : repository.findAll()){
            System.out.println(book);
        }
    }

    public Book findBook(int id) {
        return repository.findById(id);
    }

}
