package com.librarymanagementsystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.librarymanagementsystem.controller.LibraryController;
import com.librarymanagementsystem.config.DatabaseConfig;
import java.sql.Connection;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {

        try (Connection connection = DatabaseConfig.getConnection()) {

            System.out.println("Database connected successfully!");

            LibraryController controller = new LibraryController();
            controller.start();

        } catch (Exception e) {

            System.out.println("Database connection failed!");
        }
    }

}
