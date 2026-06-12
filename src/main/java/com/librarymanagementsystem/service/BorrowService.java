package com.librarymanagementsystem.service;

import com.librarymanagementsystem.model.BorrowRecord;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.repository.BorrowRepository;

public class BorrowService {

    private final BorrowRepository repository = new BorrowRepository();

    public void borrowBook(Book book, int memberId){

        if (!book.isAvailable()){
            System.out.println("Book Unavailable");
            return;
        }

        book.setAvailable(false);

        repository.save(
                new BorrowRecord(
                        book.getId(), memberId
                )
        );

        System.out.println("Book Borrowed Successfully");
    }
}
