package com.ukream.error.exception;

public class AuthenticationRequiredException extends RuntimeException{
    public AuthenticationRequiredException(String msg) {
        super(msg);
    }
}