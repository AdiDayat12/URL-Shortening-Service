package com.roadmap.sh.urlshortener.error;

import com.roadmap.sh.urlshortener.dto.ResponseAPI;
import com.roadmap.sh.urlshortener.exception.UrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseAPI> handleValidationError (MethodArgumentNotValidException e){
        String errorMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        System.out.println(errorMessage);
        return ResponseEntity.badRequest().body(ResponseAPI.builder()
                        .code(400)
                        .message(errorMessage)
                .build());
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ResponseAPI> handleUrlNotFound (UrlNotFoundException e){
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ResponseAPI.builder()
                        .code(404)
                        .message(e.getMessage())
                        .build()
        );
    }
}
