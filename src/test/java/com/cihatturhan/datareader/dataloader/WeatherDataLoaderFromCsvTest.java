package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.entities.Weather;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataLoaderFromCsvTest {

    WeatherDataLoader weatherDataLoader= new WeatherDataLoaderFromCsv();
    @Test
    void itShouldCheckIfAllTheWeathersAreLoaded() {
        //given
        int expectedNumberOfTeams=30;
        String filePath="src/main/resources/weather.csv";
        //when
        List<Weather> weathers= weatherDataLoader.getAllWeathers(filePath,new CSVFileReader());
        //then
        assertEquals(expectedNumberOfTeams,weathers.size());
    }
}