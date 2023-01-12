package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.exception.NotFoundException;
import com.cihatturhan.datareader.repository.FootballTeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FootballTeamServiceImpTest {

    @Mock
    private FootballTeamRepository footballTeamRepository;

    private FootballTeamServiceImp footballTeamServiceUnderTest;

    @BeforeEach
    void setUp() {
        footballTeamServiceUnderTest = new FootballTeamServiceImp(footballTeamRepository);
    }

    @Test
    void canGetAllFootballTeams() {
        //when
        footballTeamServiceUnderTest.getAllFootballTeams();
        //then
        verify(footballTeamRepository).findAll();
    }

    @Test
    void canFindFootballTeamById() {

        //given
        FootballTeam footballTeam = new FootballTeam(123L, "Test Team", 5, 2, 1, 2, 12, 7, 7);
        doReturn(Optional.of(footballTeam)).when(footballTeamRepository).findById(123L);

        //when
        FootballTeam expected = footballTeamServiceUnderTest.findFootballTeamById(123L);

        //then
        verify(footballTeamRepository).findById(123L);
        assertEquals("Test Team", expected.getTeamName());

    }

    @Test
    void canFindByIdThrowExceptionIfFootballTeamNotFount() {
        //given
        FootballTeam footballTeam = new FootballTeam(123L, "Test Team", 5, 2, 1, 2, 12, 7, 7);
        doReturn(Optional.of(footballTeam)).when(footballTeamRepository).findById(123L);

        //when
        FootballTeam expected = footballTeamServiceUnderTest.findFootballTeamById(123L);
        Exception exception = assertThrows(NotFoundException.class, () ->
        {
            footballTeamServiceUnderTest.findFootballTeamById(1L);
        });
        String expectedMessage = "Football Team Not Found";

        //then
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    void canCreateNewFootBallTeam() {
        //given
        FootballTeam footballTeam = new FootballTeam(null, "Test Team", 5, 2, 1, 2, 12, 7, 7);
        //when
        footballTeamServiceUnderTest.createNewFootBallTeam(footballTeam);
        //then
        ArgumentCaptor<FootballTeam> footballTeamArgumentCaptor = ArgumentCaptor.forClass(FootballTeam.class);
        verify(footballTeamRepository).save(footballTeamArgumentCaptor.capture());
        FootballTeam capturedFootballTeam = footballTeamArgumentCaptor.getValue();
        assertThat(capturedFootballTeam).isEqualTo(footballTeam);
    }

    @Test
    void updateFootballTeam() {
        //given
        FootballTeam footballTeam = new FootballTeam(123L, "Test Team", 5, 2, 1, 2, 12, 7, 7);
        given(footballTeamRepository.findById(footballTeam.getId())).willReturn(Optional.of(footballTeam));
        //when
        footballTeamServiceUnderTest.updateFootballTeam(footballTeam);
        //then
        ArgumentCaptor<FootballTeam> footballTeamArgumentCaptor = ArgumentCaptor.forClass(FootballTeam.class);
        verify(footballTeamRepository).save(footballTeamArgumentCaptor.capture());
        FootballTeam capturedFootballTeam = footballTeamArgumentCaptor.getValue();
        assertThat(capturedFootballTeam).isEqualTo(footballTeam);

    }

    @Test
    void deleteFootballTeam() {
        //given
        FootballTeam footballTeam = new FootballTeam(123L, "Test Team", 5, 2, 1, 2, 12, 7, 7);
        given(footballTeamRepository.findById(footballTeam.getId())).willReturn(Optional.of(footballTeam));
        //when
        footballTeamServiceUnderTest.deleteFootballTeam(footballTeam.getId());
        //then
        verify(footballTeamRepository).deleteById(footballTeam.getId());
    }

    @Test
    void addMultipleFootballTeam() {
        //given
        List<FootballTeam> footballTeamList= new ArrayList<>();
        FootballTeam footballTeam = new FootballTeam(122L, "Test Team", 5, 2, 1, 2, 12, 7, 7);
        footballTeamList.add(footballTeam);
        FootballTeam footballTeam2 = new FootballTeam(123L, "Test Team2", 5, 2, 1, 2, 12, 7, 7);
        footballTeamList.add(footballTeam2);
        //when
        footballTeamServiceUnderTest.addMultipleFootballTeam(footballTeamList);
        //then
        verify(footballTeamRepository).saveAll(footballTeamList);

    }
}