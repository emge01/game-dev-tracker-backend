package com.emg.game_dev_tracker_backend;

class ProjectNotFoundException extends RuntimeException {
    ProjectNotFoundException(Long id) {
        super("Could not find project " + id);
    }
}
