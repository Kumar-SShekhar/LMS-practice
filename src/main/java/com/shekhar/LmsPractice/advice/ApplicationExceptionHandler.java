package com.shekhar.LmsPractice.advice;
import com.shekhar.LmsPractice.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(UserNotFoundException.class)
//    public Map<String,String> handleInvalidStudentRetrieval(UserNotFoundException ex){
//        Map<String,String> errorMap=new HashMap<>();
//        errorMap.put("error message" , ex.getMessage());
//        return errorMap;
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(BookNotFoundException.class)
//    public Map<String, String> handleInvalidBookRetrieval(BookNotFoundException ex){
//        Map<String,String> errorMap = new HashMap<>();
//        errorMap.put("error message" , ex.getMessage());
//        return errorMap;
//    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map<String , String> handleInvalidRetrieval(NotFoundException ex){
        Map<String , String> errorMap = new HashMap<>();
        errorMap.put("error message" , ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Map<String , String> handleGenericException(Exception ex){
        Map<String , String> errorMap=new HashMap<>();
        errorMap.put("error message", ex.getMessage());
        return errorMap;
    }

}