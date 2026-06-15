package com.librarymanagementsystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.librarymanagementsystem.controller.LibraryController;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static void main(String[] args){

        LibraryController controller = new LibraryController();
        controller.start();
    }

}
