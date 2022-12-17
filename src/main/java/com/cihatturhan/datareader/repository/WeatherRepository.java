package com.cihatturhan.datareader.repository;

import com.cihatturhan.datareader.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather,Long> {

    Optional<Weather> findById(Long id);
}
