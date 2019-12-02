package com.csv.com.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVstates {
    @CsvBindByName
    private Integer SrNo;

    @CsvBindByName
    private String StateName;

    @CsvBindByName
    private Integer TIN;

    @CsvBindByName
    private  String StateCode;

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

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }
}
