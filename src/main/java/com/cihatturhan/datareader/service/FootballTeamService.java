package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;

import java.util.List;
import java.util.Optional;

public interface FootballTeamService {
    List<FootballTeam> getAllFootballTeams();
    Optional<FootballTeam> findFootballTeamById(Long id);
    FootballTeam createNewFootBallTeam(FootballTeam footballTeam);
    FootballTeam updateFootballTeam(FootballTeam footballTeam);
    void deleteFootballTeam(Long id);
    void addMultipleFootballTeam(List<FootballTeam> footballTeams);
}
