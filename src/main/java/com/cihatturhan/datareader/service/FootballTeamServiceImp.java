package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.exception.NotFoundException;
import com.cihatturhan.datareader.repository.FootballTeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class FootballTeamServiceImp implements FootballTeamService {

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Override
    public List<FootballTeam> getAllFootballTeams() {
        return footballTeamRepository.findAll();
    }

    @Override
    public FootballTeam findFootballTeamById(Long id) {

        return footballTeamRepository.findById(id).orElseThrow(() -> new NotFoundException("Football Team Not Found "));
    }

    @Override
    public FootballTeam createNewFootBallTeam(FootballTeam footballTeam) {
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public FootballTeam updateFootballTeam(FootballTeam footballTeam) {
        footballTeamRepository.findById(footballTeam.getId())
                .orElseThrow(()->new NotFoundException("FootballTeam Not Found"));

        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public void deleteFootballTeam(Long id) {

        footballTeamRepository.findById(id).orElseThrow(() -> new NotFoundException("FootballTeam Not Found"));

        footballTeamRepository.deleteById(id);
    }

    @Override
    public void addMultipleFootballTeam(List<FootballTeam> list) {
        footballTeamRepository.saveAll(list);
    }
}
