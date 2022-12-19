package com.cihatturhan.datareader.controller;

import com.cihatturhan.datareader.entities.Weather;
import com.cihatturhan.datareader.service.WeatherService;
import org.hibernate.tool.schema.internal.HibernateSchemaManagementTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<?> getAllWeathers(){
        return new ResponseEntity<>(weatherService.getAllWeathers(), HttpStatus.OK);
    }
    @GetMapping({"/{id}"})
    public ResponseEntity<?> getWeatherById(@PathVariable Long id){
        return new ResponseEntity<>(weatherService.findWeatherById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createNewWeather(@RequestBody Weather weather){
        return new ResponseEntity<>(weatherService.createNewWeather(weather), HttpStatus.CREATED);
    }
    @PutMapping ResponseEntity<?> updateWeather(@RequestBody Weather weather){
        return new ResponseEntity<>(weatherService.updateWeather(weather), HttpStatus.OK);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> deleteWeather(@PathVariable Long id){
        weatherService.deleteWeather(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
