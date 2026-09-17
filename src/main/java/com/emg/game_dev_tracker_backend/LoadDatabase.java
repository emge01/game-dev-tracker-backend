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
    CommandLineRunner initDatabase(ProjectRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Project("Cipheria", "UE5", new String[]{"pc"})));
            log.info("Preloading " + repository.save(new Project("Split Self", "UE5", new String[]{"pc", "console"})));
        };
    }
}
