package com.infosys.training.tdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TDDSimulation {
    private static final Logger logger = LoggerFactory.getLogger(TDDSimulation.class);

    public static void main(String[] args) {
        logger.info("Starting TDDSimulation App");
        SpringApplication.run(TDDSimulation.class, args);
    }
}
