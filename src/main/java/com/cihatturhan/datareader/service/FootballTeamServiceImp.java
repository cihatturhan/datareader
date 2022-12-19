package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.repository.FootballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FootballTeamServiceImp implements FootballTeamService {

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Override
    public List<FootballTeam> getAllFootballTeams() {
        return footballTeamRepository.findAll();
    }

    @Override
    public FootballTeam findFootballTeamById(Long id) {
        return footballTeamRepository.findById(id).orElseThrow(() -> new RuntimeException("FootballTeam not found"));
    }

    @Override
    public FootballTeam createNewFootBallTeam(FootballTeam footballTeam) {
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public FootballTeam updateFootballTeam(FootballTeam footballTeam) {
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public void deleteFootballTeam(Long id) {

        footballTeamRepository.deleteById(id);
    }
}
