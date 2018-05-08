package com.cts.fsd.SkillTrackerAPI;

/**
 * @author Sandeep
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cts.fsd.SkillTrackerAPI")

public class SkillTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillTrackerApiApplication.class, args);
	}
}
