package com.cihatturhan.datareader.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private int day;
    private int mxT;
    private int mnT;
    private int avT;
    private float avDP;
    private int _1HrP_TPcpn;
    private int pDir;
    private float AvSp;
    private int dir;
    private int mxS;
    private float skyC;
    private int mxR;
    private int mn;
    private float r_AvSLP;
}
