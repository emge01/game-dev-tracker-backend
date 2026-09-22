package com.emg.game_dev_tracker_backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
class MilestoneNotFoundAdvice {
    @ExceptionHandler(MilestoneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String MilestoneNotFoundHandler(MilestoneNotFoundException ex) {
        return ex.getMessage();
    }
    
}
