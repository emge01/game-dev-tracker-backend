package com.emg.game_dev_tracker_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emg.game_dev_tracker_backend.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
