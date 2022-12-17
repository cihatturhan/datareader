package com.cihatturhan.datareader.repository;

import com.cihatturhan.datareader.entities.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballTeamRepository extends JpaRepository<FootballTeam,Long> {


    Optional<FootballTeam> findById(Long id);
}
