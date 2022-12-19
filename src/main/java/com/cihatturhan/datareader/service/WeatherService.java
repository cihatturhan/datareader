package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.Weather;

import java.util.List;

public interface WeatherService {
    List<Weather> getAllWeathers();

    Weather findWeatherById(Long id);

    Weather createNewWeather(Weather weather);

    Weather updateWeather(Weather weather);

    void deleteWeather(Long id);

}
