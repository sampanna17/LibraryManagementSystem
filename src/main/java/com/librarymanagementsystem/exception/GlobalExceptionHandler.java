package com.librarymanagementsystem.exception;

import com.librarymanagementsystem.dto.ApiResponse;

public class GlobalExceptionHandler {

    public static void handle(Exception e) {

        if (e instanceof BookNotFoundException) {
            System.out.println(new ApiResponse<>(
                    404,
                    false,
                    e.getMessage(),
                    null
            ));
        } else {
            System.out.println(new ApiResponse<>(
                    500,
                    false,
                    "Internal Server Error",
                    null
            ));
        }
    }
}