package com.emg.game_dev_tracker_backend;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
class ProjectController {
    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/projects")
    List<Project> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    // Single item

    @GetMapping("/projects/{id}")
    Project one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    @PutMapping("/projects/{id}")
    Project replaceProject(@RequestBody Project newProject, @PathVariable Long id) {
        return repository.findById(id).map(project -> {
            project.setTitle(newProject.getTitle());
            project.setEngine(newProject.getEngine());
            project.setPlatforms(newProject.getPlatforms());
            project.setStatus(newProject.getStatus());
            return repository.save(project);
        }).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @PatchMapping("/projects/{id}")
    Project updateProjectDetails(@RequestBody Project newProject, @PathVariable Long id) {
        return repository.findById(id).map(project -> {
            if (newProject.getTitle() != null) {
                project.setTitle(newProject.getTitle());
            }
            if (newProject.getEngine() != null) {
                project.setEngine(newProject.getEngine());
            }
            if (newProject.getPlatforms() != null) {
                project.setPlatforms(newProject.getPlatforms());
            }
            if (newProject.getStatus() != null) {
                project.setStatus(newProject.getStatus());
            }
            return repository.save(project);
        }).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @DeleteMapping("/projects/{id}")
    void deleteProject(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
