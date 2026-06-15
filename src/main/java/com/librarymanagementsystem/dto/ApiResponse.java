package com.librarymanagementsystem.dto;

public class ApiResponse<T> {

    private int statusCode;
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(int statusCode, boolean success, String message, T data){
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
