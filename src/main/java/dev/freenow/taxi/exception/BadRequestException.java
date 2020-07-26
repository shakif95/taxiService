package dev.freenow.taxi.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends Exception {

    public BadRequestException(String message){
        super(message);
    }
}
