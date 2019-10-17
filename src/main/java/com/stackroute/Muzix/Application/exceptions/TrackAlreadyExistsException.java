package com.stackroute.Muzix.Application.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class TrackAlreadyExistsException extends Exception {
    private String message;
    public TrackAlreadyExistsException(){}
    public TrackAlreadyExistsException(String message){
        super(message);
        this.message= message;
    }


}
