package com.cihatturhan.datareader.dataloader.utils;

import com.cihatturhan.datareader.entities.FootballTeam;
import com.cihatturhan.datareader.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileReaderTest {


    CSVFileReader csvFileReader = new CSVFileReader();

    @Test
    void itShouldCheckIfAllTheLinesAreLoaded() {
        //given
        int expectedNumberOfLines = 21;
        //when
        List<String> lines = csvFileReader.csvFileToStringList("src/test/resources/football.csv");
        //then
        assertEquals(expectedNumberOfLines, lines.size());
    }

    @Test
    void itShouldCheckIfNoSuchFileExceptionIsThrown(){
        Exception exception = assertThrows(NotFoundException.class, () -> {
            csvFileReader.csvFileToStringList("somePath");
        });
        String expectedMessage = "CVS File is not exist";


        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}