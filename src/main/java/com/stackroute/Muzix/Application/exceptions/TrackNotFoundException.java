package com.stackroute.Muzix.Application.exceptions;

public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException(){}
    public TrackNotFoundException(String message){
        super(message);
        this.message= message;
    }
}
