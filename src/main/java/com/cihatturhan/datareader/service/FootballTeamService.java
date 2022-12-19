package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;

import java.util.List;

public interface FootballTeamService {
    List<FootballTeam> getAllFootballTeams();
    FootballTeam findFootballTeamById(Long id);
    FootballTeam createNewFootBallTeam(FootballTeam footballTeam);
    FootballTeam updateFootballTeam(FootballTeam footballTeam);
    void deleteFootballTeam(Long id);
    void addMultipleFootballTeam(List<FootballTeam> list);
}
