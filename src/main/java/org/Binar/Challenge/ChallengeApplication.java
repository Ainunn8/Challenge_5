package org.Binar.Challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.ParseException;

@SpringBootApplication
@EnableScheduling
public class ChallengeApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ChallengeApplication.class, args);
	}
}
