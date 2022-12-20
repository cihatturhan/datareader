package com.cihatturhan.datareader;

import com.cihatturhan.datareader.dataloader.FootballTeamDataLoader;
import com.cihatturhan.datareader.dataloader.WeatherDataLoader;
import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.service.FootballTeamService;
import com.cihatturhan.datareader.service.WeatherService;
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
    CommandLineRunner footballTeamDataRun(FootballTeamService footballTeamService, FootballTeamDataLoader footballTeamDataLoader) {
        return args -> {
            footballTeamService.addMultipleFootballTeam(footballTeamDataLoader.getAllFootballTeams("src/main/resources/football.csv",new CSVFileReader()));


        };
    }

    @Bean
    CommandLineRunner WeatherDataRun(WeatherService weatherService, WeatherDataLoader weatherDataLoader) {
        return args -> {

            weatherService.addMultipleWeathers(weatherDataLoader.getAllWeathers("src/main/resources/weather.csv", new CSVFileReader()));

        };
    }

}
