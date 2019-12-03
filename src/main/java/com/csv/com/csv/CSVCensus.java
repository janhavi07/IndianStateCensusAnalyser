package com.csv.com.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVCensus implements Comparable<CSVCensus> {

    @CsvBindByName
    private String State;

    @CsvBindByName
    private Double Population;

    @CsvBindByName
    private Double AreaInSqKm;

    @CsvBindByName
    private Double DensityPerSqKm;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Double getPopulation() {
        return Population;
    }

    public void setPopulation(Double population) {
        Population = population;
    }

    public Double getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(Double areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public Double getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(Double densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }

    @Override
    public int compareTo(CSVCensus census) {
        return this.State.compareTo(census.getState());
    }
}
