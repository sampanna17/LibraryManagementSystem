package com.librarymanagementsystem.util;

public class ValidationUtil {

    public static void validateBookTitle(String title) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Book title cannot be empty"
            );
        }
    }

    public static void validateAuthor(String author) {

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Author name cannot be empty"
            );
        }
    }

    public static void validateMemberName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Member name cannot be empty"
            );
        }
    }

    public static void validateId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID must be greater than zero"
            );
        }
    }
}