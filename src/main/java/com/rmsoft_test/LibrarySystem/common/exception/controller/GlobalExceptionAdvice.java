package com.rmsoft_test.LibrarySystem.common.exception.controller;

import com.rmsoft_test.LibrarySystem.common.exception.BusinessLogicException;
import com.rmsoft_test.LibrarySystem.common.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handleMethodArgumentNoValidException(MethodArgumentNotValidException e){
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstrainViolationException(ConstraintViolationException e){
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());
        return response;
    }

    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e){
        ErrorResponse response = ErrorResponse.of(e.getExceptionCode());
        return new ResponseEntity<>(response,HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
