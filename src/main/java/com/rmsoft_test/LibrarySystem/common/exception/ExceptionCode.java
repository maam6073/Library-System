package com.rmsoft_test.LibrarySystem.common.exception;

import lombok.Getter;

public enum ExceptionCode {
    USER_NOT_FOUND(404,"User Not Found"),
    USER_EXISTS(409,"User Exists");
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
