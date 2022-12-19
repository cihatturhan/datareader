package com.cihatturhan.datareader;

import com.cihatturhan.datareader.dataloader.FootballTeamDataLoader;
import com.cihatturhan.datareader.service.FootballTeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatareaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatareaderApplication.class, args);
	}

	@Bean
	CommandLineRunner run(FootballTeamService footballTeamService, FootballTeamDataLoader footballTeamDataLoader) {
		return args -> {
			footballTeamService.addMultipleFootballTeam(footballTeamDataLoader.getAllFootballTeams());

		};
	}

}
