package com.acme.practicebackend1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
public class PracticeBackend1Application {

    public static void main(String[] args) {
        SpringApplication.run(PracticeBackend1Application.class, args);
    }

}
