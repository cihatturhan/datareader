package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.entities.FootballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FootballTeamsDataLoaderFromCsv implements FootballTeamDataLoader{

    @Autowired
    private CSVFileReader csvFileReader;
    static final String filePath= "src/main/resources/football.csv";

    // read Datas from csv file and return FootballTeam List
    @Override
    public List<FootballTeam> getAllFootballTeams() {

        List<String> footballTeamsInLines=csvFileReader.csvFileToStringList(filePath);
        List<FootballTeam> footballTeams = new ArrayList<>();

        footballTeamsInLines.stream().forEach((line)->{
                   if(convertLineToFootballTeam(line)!=null)
                       footballTeams.add(convertLineToFootballTeam(line));
        });
        return footballTeams;
    }
    private FootballTeam convertLineToFootballTeam(String str) {
        FootballTeam footballTeam = new FootballTeam();
        try {
            String[] line = str.split(",");
            footballTeam.setTeamName(line[0]);
            footballTeam.setGames(Integer.parseInt(line[1]));
            footballTeam.setWins(Integer.parseInt(line[2]));
            footballTeam.setLosses(Integer.parseInt(line[3]));
            footballTeam.setDraws(Integer.parseInt(line[4]));
            footballTeam.setGoals(Integer.parseInt(line[5]));
            footballTeam.setGoals_Allowed(Integer.parseInt(line[6]));
            footballTeam.setPoints(Integer.parseInt(line[7]));

        } catch (Exception e) {
            return null;
        }

        return footballTeam;
    }


}
