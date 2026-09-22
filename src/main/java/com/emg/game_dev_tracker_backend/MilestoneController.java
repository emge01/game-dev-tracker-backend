package com.emg.game_dev_tracker_backend;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController 
class MilestoneController {
    private final MilestoneRepository repository;

    MilestoneController(MilestoneRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/projects/{id}/milestones")
    List<Milestone> allMilestones(@PathVariable("id") Long projectId) {
        return  repository.findByProjectId(projectId);
    }

    @GetMapping("/projects/{id}/milestones/{milestoneId}")
    Milestone oneMilestone(@PathVariable("milestoneId") Long id) {
        return repository.findById(id).orElseThrow(() -> new MilestoneNotFoundException(id));
    }

    @PostMapping("/projects/{id}/milestones")
    @ResponseStatus(HttpStatus.CREATED)
    Milestone newMilestone(@RequestBody Milestone newMilestone) {
        return repository.save(newMilestone);
    }

    @PutMapping("/projects/{id}/milestones/{milestoneId}")
    Milestone replaceMilestone(@RequestBody Milestone newMilestone, @PathVariable("milestoneId") Long id) {
        return repository.findById(id).map(milestone -> {
            milestone.setTitle(newMilestone.getTitle());
            milestone.setDescription(newMilestone.getDescription());
            milestone.setStatus(newMilestone.getStatus());
            return repository.save(milestone);
        }).orElseThrow(() -> new MilestoneNotFoundException(id));
    }

    @PatchMapping("/projects/{id}/milestones/{milestoneId}")
    Milestone updateMilestoneDetails(@RequestBody Milestone newMilestone, @PathVariable("milestoneId") Long id) {
        return repository.findById(id).map(milestone -> {
            if (newMilestone.getTitle() != null) {
                milestone.setTitle(newMilestone.getTitle());
            }
            if (newMilestone.getDescription() != null) {
                milestone.setDescription(newMilestone.getDescription());
            }
            if (newMilestone.getStatus() != null) {
                milestone.setStatus(newMilestone.getStatus());
            }
            return repository.save(milestone);
        }).orElseThrow(() -> new MilestoneNotFoundException(id));
    }

    @DeleteMapping("/projects/{id}/milestones/{milestoneId}")
    void deleteMilestone(@PathVariable("milestoneId") Long id) {
        repository.deleteById(id);
    }
}
