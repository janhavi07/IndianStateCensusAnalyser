package com.csv.com.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVstates {
    @CsvBindByName
    private String SrNo;

    @CsvBindByName
    private String StateName;

    @CsvBindByName
    private String TIN;

    @CsvBindByName
    private  String StateCode;

    public Integer getSrNo() {
        return SrNo;
    }

    public void setSrNo(String srNo) {
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

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }
}
