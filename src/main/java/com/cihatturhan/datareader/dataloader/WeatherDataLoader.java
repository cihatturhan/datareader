package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.entities.Weather;

import java.util.List;

public interface WeatherDataLoader {
    List<Weather> getAllWeathers();
}
