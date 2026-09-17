package com.emg.game_dev_tracker_backend;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
