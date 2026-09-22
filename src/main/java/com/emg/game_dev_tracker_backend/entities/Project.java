package com.emg.game_dev_tracker_backend.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

enum Status {
    CONCEPT, PRE_PRODUCTION, PRODUCTION, ALPHA, BETA, SHIPPED
}

@Entity 
public class Project {
    
    private @Id
    @GeneratedValue Long id;
    private String user_id;
    private String title;
    private String engine;
    private String[] platforms;
    private Status status;

    public Project() {}

    public Project(String title, String engine, String[] platforms) {
        this.title = title;
        this.engine = engine;
        this.platforms = platforms;
        this.status = Status.CONCEPT;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override 
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Project))
            return  false;
        Project project = (Project) o;
        return Objects.equals(this.id, project.id) && Objects.equals(this.title, project.title);
    }

    @Override 
    public int hashCode() {
        return Objects.hash(this.id, this.title);
    }

    @Override 
    public String toString() {
        return "Project{" + "id=" + this.id + ", title='" + this.title + "}\n";
    }

}
