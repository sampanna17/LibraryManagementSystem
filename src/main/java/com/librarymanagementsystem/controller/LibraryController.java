package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.dto.ApiResponse;
import com.librarymanagementsystem.exception.BookNotFoundException;
import com.librarymanagementsystem.exception.BookUnavailableException;
import com.librarymanagementsystem.exception.GlobalExceptionHandler;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.Member;
import com.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.service.BorrowService;
import com.librarymanagementsystem.service.MemberService;

import java.util.Scanner;

public class LibraryController {

    private final Scanner sc = new Scanner(System.in);

    private final BookService bookService = new BookService();
    private final BorrowService borrowService = new BorrowService();
    private final MemberService memberService = new MemberService();

    public void start() {

        while (true) {

            try {

                System.out.println("\n===== LIBRARY =====");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. View Books By ID");
                System.out.println("4. Add Member");
                System.out.println("5. View Members");
                System.out.println("6. Borrow Book");
                System.out.println("7. Exit");

                System.out.print("Enter Choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1 -> addBook();
                    case 2 -> bookService.displayBooks();
                    case 3 -> findBookById();
                    case 4 -> addMember();
                    case 5 -> memberService.displayMembers();
                    case 6 -> borrowBook();
                    case 7 -> {
                        System.out.println("Thank you for using Library System.");
                        return;
                    }

                    default -> System.out.println("Invalid Option");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addBook() {

        try {

            System.out.print("Book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            bookService.addBook(
                    new Book(id, title, author)
            );

            System.out.println("Book added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addMember() {

        try {

            System.out.print("Member ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Name: ");
            String name = sc.nextLine();

            memberService.addMember(
                    new Member(id, name)
            );

            System.out.println("Member added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrowBook() {

        try {

            System.out.print("Book ID: ");
            int bookId = Integer.parseInt(sc.nextLine());

            System.out.print("Member ID: ");
            int memberId = Integer.parseInt(sc.nextLine());

            Book book = bookService.findBook(bookId);

            borrowService.borrowBook(book, memberId);

            System.out.println("Book borrowed successfully.");

        } catch (BookNotFoundException |
                 BookUnavailableException |
                 IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
    private void findBookById() {

        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            Book book = bookService.findBook(id);

            System.out.println(new ApiResponse<>(
                    200,
                    true,
                    "Book found successfully",
                    book
            ));

        } catch (Exception e) {
            GlobalExceptionHandler.handle(e);
        }
    }

}