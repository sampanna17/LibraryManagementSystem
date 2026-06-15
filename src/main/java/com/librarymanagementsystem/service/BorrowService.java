package com.librarymanagementsystem.service;

import com.librarymanagementsystem.exception.BookUnavailableException;
import com.librarymanagementsystem.model.BorrowRecord;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.repository.BorrowRepository;

public class BorrowService {

    private final BorrowRepository repository = new BorrowRepository();

    public void borrowBook(Book book, int memberId){

        if (!book.isAvailable()) {

            throw new BookUnavailableException(
                    "Book is already borrowed"
            );
        }

        book.setAvailable(false);

        repository.save(
                new BorrowRecord(
                        book.getId(),
                        memberId
                )
        );
    }
}
