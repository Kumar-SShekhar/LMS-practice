package com.shekhar.LmsPractice.exception;


public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message){
        super(message);
    }
}
