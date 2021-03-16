package com.example.weather.integration.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidDetails {


    private String state;
    private long date;
    private Integer positive;
    private Integer hospitalizedCurrently;
    private Integer recovered;
    private Integer death;
    private Integer positiveCasesViral;
    private Integer totalTestResults;


    public String getState() {
        return state;
    }

    public String getDate() {
        String dt = String.valueOf(date);
        char[] cdt = dt.toCharArray();
        StringBuilder sb = new StringBuilder(dt);
        sb.insert(4, "-");
        StringBuilder sb1 = new StringBuilder(sb);
        sb1.insert(7,"-");
        return sb1.toString();
    }

    public void setDate(long date) {
        this.date =  date;
    }

    public Integer getPositive() {
        return positive;
    }

    public void setPositive(Integer positive) {
        this.positive = positive;
    }

    public Integer getHospitalizedCurrently() {
        return hospitalizedCurrently;
    }

    public void setHospitalizedCurrently(Integer hospitalizedCurrently) {
        this.hospitalizedCurrently = hospitalizedCurrently;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    public Integer getPositiveCasesViral() {
        return positiveCasesViral;
    }

    public void setPositiveCasesViral(Integer positiveCasesViral) {
        this.positiveCasesViral = positiveCasesViral;
    }

    public Integer getTotalTestResults() {
        return totalTestResults;
    }

    public void setTotalTestResults(Integer totalTestResults) {
        this.totalTestResults = totalTestResults;
    }

    public void setState(String state) {
        this.state = state;
    }
}
