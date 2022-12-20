package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.entities.FootballTeam;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballTeamsDataLoaderFromCsvTest {


    FootballTeamDataLoader footballTeamDataLoader =  new FootballTeamsDataLoaderFromCsv();

    @Test
    void  itShouldCheckIfAllTheFootballTeamsAreLoaded() {
        //given
        int expectedNumberOfTeams=20;
        String filePath="src/test/resources/football.csv";
        //when
        List<FootballTeam> footballTeams= footballTeamDataLoader.getAllFootballTeams(filePath, new CSVFileReader());
        //then
        assertEquals(expectedNumberOfTeams,footballTeams.size());
    }
}