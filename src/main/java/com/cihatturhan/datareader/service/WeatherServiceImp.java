package com.cihatturhan.datareader.service;

import com.cihatturhan.datareader.entities.Weather;
import com.cihatturhan.datareader.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WeatherServiceImp implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public List<Weather> getAllWeathers() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather findWeatherById(Long id) {
        return weatherRepository.findById(id).orElseThrow(() -> new RuntimeException("Weather not found"));
    }

    @Override
    public Weather createNewWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public Weather updateWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }

    @Override
    public void addMultipleWeathers(List<Weather> weathers) {
        weatherRepository.saveAll(weathers);
    }
}
