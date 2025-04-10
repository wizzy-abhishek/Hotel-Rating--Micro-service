package com.hotel.exception;

import com.hotel.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<ApiResponse> handleResourceException(ResourceException r){
        ApiResponse response =  ApiResponse
                .builder()
                .message(r.getMessage())
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
    }
}
