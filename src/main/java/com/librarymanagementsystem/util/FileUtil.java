package com.librarymanagementsystem.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.librarymanagementsystem.model.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    private static final String FILE_PATH = "data/books.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    // READ
    public static List<Book> read() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) {
                return new ArrayList<>();
            }

            Book[] books = mapper.readValue(file, Book[].class);
            return new ArrayList<>(Arrays.asList(books));

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // WRITE
    public static void write(List<Book> books) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), books);
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}