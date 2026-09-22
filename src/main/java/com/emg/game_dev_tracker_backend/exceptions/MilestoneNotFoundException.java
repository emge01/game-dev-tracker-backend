package com.emg.game_dev_tracker_backend.exceptions;

public class MilestoneNotFoundException extends RuntimeException{
    public MilestoneNotFoundException(Long id) {
        super("Could not find milestone " + id);
    }
}
