package com.emg.game_dev_tracker_backend.exceptions;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Could not find project " + id);
    }
}
