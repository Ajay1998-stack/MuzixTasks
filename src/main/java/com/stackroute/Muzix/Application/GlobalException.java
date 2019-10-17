package com.stackroute.Muzix.Application;

import com.stackroute.Muzix.Application.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Application.exceptions.TrackNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public String handleTrackAlreadyExistsException(TrackAlreadyExistsException exception){
            return exception.getMessage();
    }
    @ExceptionHandler
    public String handleTrackNotFoundException(TrackNotFoundException exception){
        return exception.getMessage();
    }
}
