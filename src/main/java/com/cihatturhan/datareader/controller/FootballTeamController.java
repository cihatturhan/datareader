package com.cihatturhan.datareader.controller;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.service.FootballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/football-team")
public class FootballTeamController {

    @Autowired
    FootballTeamService footballTeamService;

    @GetMapping
    public ResponseEntity<?> getAllFootballTeams(){

        return new ResponseEntity<>(footballTeamService.getAllFootballTeams(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getFootballTeamById(@PathVariable Long id){
        return new ResponseEntity<>(footballTeamService.findFootballTeamById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createFootballTeam(@RequestBody FootballTeam footballTeam){
        return new ResponseEntity<>(footballTeamService.createNewFootBallTeam(footballTeam),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> updateFootballTeam(@RequestBody FootballTeam footballTeam){
        return new ResponseEntity<>(footballTeamService.updateFootballTeam(footballTeam),HttpStatus.OK);
    }
    @DeleteMapping({"/id"})
    public ResponseEntity<?> deleteFootballTeam(@PathVariable Long id){
        footballTeamService.deleteFootballTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
