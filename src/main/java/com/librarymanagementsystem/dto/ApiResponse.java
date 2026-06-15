package com.librarymanagementsystem.dto;

public class ApiResponse<T> {

    private final int statusCode;
    private final boolean success;
    private final String message;
    private final T data;

    public ApiResponse(int statusCode, boolean success, String message, T data){
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
