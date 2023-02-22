package com.SpringBootTest.test.advisor;

import com.SpringBootTest.test.utill.StandardResponse;
import com.SpringBootTest.test.exception.NotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity hanleNotFoundException(NotFoundExeption e){
        return new ResponseEntity(new StandardResponse(401,"Validation Exception"), HttpStatus.NOT_FOUND);
    }
}
