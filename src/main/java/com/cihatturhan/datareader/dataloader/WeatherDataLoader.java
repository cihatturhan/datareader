package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.entities.Weather;

import java.util.List;

public interface WeatherDataLoader {
    List<Weather> getAllWeathers(String filePath, CSVFileReader csvFileReader);
}
