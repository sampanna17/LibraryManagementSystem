package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.Member;
import com.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.service.BorrowService;
import com.librarymanagementsystem.service.MemberService;

import java.util.Scanner;
public class LibraryController {

    private final Scanner sc = new Scanner(System.in);

    private final BookService bookService =new BookService();
    private final BorrowService borrowService = new BorrowService();
    private final MemberService memberService =  new MemberService();

    public void start(){
        while(true){
            System.out.println("\n===== LIBRARY =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> addBook();

                case 2 -> bookService.displayBooks();

                case 3 -> addMember();

                case 4 -> memberService.displayMembers();

                case 5 -> borrowBook();

                case 6 -> System.exit(0);

                default -> System.out.println("Invalid Option");
            }
        }
    }

    private void addBook(){
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        bookService.addBook(
                new Book(id, title, author)
        );
    }

    private void addMember(){
        System.out.print("Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        memberService.addMember(
                new Member(id, name)
        );
    }

    private void borrowBook(){

        System.out.print("Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Member ID: ");
        int memberId = sc.nextInt();

        Book book = bookService.findBook(bookId);

        if (book != null) {
            borrowService.borrowBook(book, memberId);
        } else {
            System.out.println("Book not found");
        }
    }
}
