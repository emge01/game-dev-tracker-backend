package com.emg.game_dev_tracker_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean 
    CommandLineRunner initDatabase(ProjectRepository repository, MilestoneRepository repository2) {
        return args -> {
            Project project1 = repository.save(new Project("Test Game 1", "UE5", new String[]{"pc"}));
            Project project2 = repository.save(new Project("Test Game 2", "UE5", new String[]{"pc", "console"}));

            repository2.save(new Milestone(project1, "Game Design Document"));
            repository2.save(new Milestone(project1, "Prototype"));
            repository2.save(new Milestone(project2, "Alpha Build"));
        };
    }
    
}
