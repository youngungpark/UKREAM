package com.ukream.error.exception;

public class AuthenticationFailureException extends RuntimeException{
    public AuthenticationFailureException(String msg) {
        super(msg);
    }
}