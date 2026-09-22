package com.emg.game_dev_tracker_backend;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

enum MilestoneStatus {
    TO_DO, IN_PROGRESS, COMPLETE
}

@Entity 
class Milestone {
    
    private @Id
    @GeneratedValue Long id;
    @ManyToOne 
    @JoinColumn(name = "project_id")
    private Project project;
    private String title;
    private String description;
    private MilestoneStatus status;

    public Milestone() {}

    Milestone(Project project, String title) {
        this.project = project;
        this.title = title;
        this.status = MilestoneStatus.TO_DO;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MilestoneStatus getStatus() {
        return status;
    }

    public void setStatus(MilestoneStatus status) {
        this.status = status;
    }

    @Override 
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Milestone))
            return  false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(this.id, milestone.id) && Objects.equals(this.title, milestone.title);
    }

    @Override 
    public int hashCode() {
        return Objects.hash(this.id, this.title);
    }

    @Override 
    public String toString() {
        return "Milestone{" + "id= " + this.id + "project= " + this.project + "title= " + this.title + "}\n";
    }
    
}
