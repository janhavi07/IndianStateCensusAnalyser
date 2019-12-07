package com.csv.com.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVCensus implements Comparable<CSVCensus> {

    @CsvBindByName
    private String State;

    @CsvBindByName
    private String Population;

    @CsvBindByName
    private Double AreaInSqKm;

    @CsvBindByName
    private String DensityPerSqKm;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public Double getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(Double areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return getState() + " " + getPopulation() + " " + getAreaInSqKm() + " " + getDensityPerSqKm();
    }

    @Override
    public int compareTo(CSVCensus census) {
        return this.State.compareTo(census.getState());
    }
}
