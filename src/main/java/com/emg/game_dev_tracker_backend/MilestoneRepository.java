package com.emg.game_dev_tracker_backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface MilestoneRepository extends JpaRepository<Milestone, Long>{
    List<Milestone> findByProjectId(Long projectId);
}
