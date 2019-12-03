package com.csv.com.csv;

import com.opencsv.bean.CsvBindByName;

public class ReplicaCSVStates {
    @CsvBindByName
    private Integer SrNo;

    @CsvBindByName
    private String StateName;

    @CsvBindByName
    private Integer TIN;

    @CsvBindByName
    private  String StateCode;


    private String Population;
    private String AreaInSqKm;
    private String DensityPerSqKm;

    public Integer getSrNo() {
        return SrNo;
    }

    public void setSrNo(Integer srNo) {
        SrNo = srNo;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public Integer getTIN() {
        return TIN;
    }

    public void setTIN(Integer TIN) {
        this.TIN = TIN;
    }

    public String getStateCode(String stateCode) {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }
}
