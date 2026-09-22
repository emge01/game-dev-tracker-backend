package com.emg.game_dev_tracker_backend;

class MilestoneNotFoundException extends RuntimeException{
    MilestoneNotFoundException(Long id) {
        super("Could not find milestone " + id);
    }
}
