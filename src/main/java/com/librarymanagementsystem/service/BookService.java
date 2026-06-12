package com.librarymanagementsystem.service;

import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.model.Book;

public class BookService {

    // Create one BookRepository object and keep using it inside this class.
    private final BookRepository repository =
            new BookRepository();

    public void addBook(Book book){
        new BookRepository();
    }

    public void displayBooks(){
        for (Book book : repository.findAll()){
            System.out.println(book);
        }
    }

    public Book findBook(int id){
        return repository.findById(id);
    }

}
