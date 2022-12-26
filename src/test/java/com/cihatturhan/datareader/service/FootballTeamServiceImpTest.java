package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.repository.FootballTeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FootballTeamServiceImpTest {

    @Mock
    private FootballTeamRepository footballTeamRepository;
     private FootballTeamServiceImp footballTeamServiceUnderTest;

     @BeforeEach
     void setUp(){
         footballTeamServiceUnderTest = new FootballTeamServiceImp(footballTeamRepository);
     }

    @Test
    void getAllFootballTeams() {
    }

    @Test
    void findFootballTeamById() {
    }

    @Test
    void createNewFootBallTeam() {
         //given
        FootballTeam footballTeam= new FootballTeam(null,"Test Team",5,2,1,2,12,7,7);
         //when
        footballTeamServiceUnderTest.createNewFootBallTeam(footballTeam);
         //then
        ArgumentCaptor<FootballTeam> footballTeamArgumentCaptor= ArgumentCaptor.forClass(FootballTeam.class);
        verify(footballTeamRepository).save(footballTeamArgumentCaptor.capture());
        FootballTeam capturedFootballTeam= footballTeamArgumentCaptor.getValue();
        assertThat(capturedFootballTeam).isEqualTo(footballTeam);
    }

    @Test
    void updateFootballTeam() {
    }

    @Test
    void deleteFootballTeam() {
    }

    @Test
    void addMultipleFootballTeam() {
    }
}