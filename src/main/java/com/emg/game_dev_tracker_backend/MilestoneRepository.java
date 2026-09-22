package com.emg.game_dev_tracker_backend;

import org.springframework.data.jpa.repository.JpaRepository;

interface MilestoneRepository extends JpaRepository<Milestone, Long>{
    
}
