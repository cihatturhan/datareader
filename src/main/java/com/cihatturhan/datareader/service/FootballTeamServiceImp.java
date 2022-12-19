package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.exception.NotFoundException;
import com.cihatturhan.datareader.repository.FootballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballTeamServiceImp implements FootballTeamService {

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Override
    public List<FootballTeam> getAllFootballTeams() {
        return footballTeamRepository.findAll();
    }

    @Override
    public Optional<FootballTeam> findFootballTeamById(Long id) {

        return Optional.ofNullable(footballTeamRepository.findById(id).orElseThrow(() -> new NotFoundException("FootballTeam Not Found")));
//        if(findFootballTeamById(id)==null){
//            throw new NotFoundException("FootballTeam Not Found");
//        }
//        return footballTeamRepository.findById(id);
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

    @Override
    public void addMultipleFootballTeam(List<FootballTeam> list) {
        footballTeamRepository.saveAll(list);
    }
}
