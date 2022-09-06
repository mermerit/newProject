package com.example.user.Infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<?>ResourseNotFoundException(ResourseNotFoundException ex , WebRequest request) {
    ExceptionDetail exceptionDetail = new ExceptionDetail(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

}
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>GlobalNotFoundException(Exception ex , WebRequest request)
    {
        ExceptionDetail exceptionDetail= new ExceptionDetail(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
