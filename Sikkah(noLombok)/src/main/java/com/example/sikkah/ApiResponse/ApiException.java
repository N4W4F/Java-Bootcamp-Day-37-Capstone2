package com.example.sikkah.ApiResponse;

public class ApiException extends RuntimeException {
    public ApiException (String message) {
        super(message);
    }
}
