package com.emg.game_dev_tracker_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emg.game_dev_tracker_backend.entities.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long>{
    List<Milestone> findByProjectId(Long projectId);
}
