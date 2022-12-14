package com.cihatturhan.datareader.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeam {
    private String teamName;
    private int games;
    private int wins;
    private int losses;
    private int draws;
    private int goals;
    private int goals_Allowed;
    private int points;
}
