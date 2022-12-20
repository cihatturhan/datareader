package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.entities.FootballTeam;

import java.util.List;

public interface FootballTeamDataLoader {
    List<FootballTeam> getAllFootballTeams(String filePath, CSVFileReader csvFileReader);
}
