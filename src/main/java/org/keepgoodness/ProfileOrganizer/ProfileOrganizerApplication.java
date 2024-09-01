package org.keepgoodness.ProfileOrganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ProfileOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileOrganizerApplication.class, args);
	}

}
