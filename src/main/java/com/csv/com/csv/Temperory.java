package com.csv.com.csv;

public class Temperory {
    private static final String CLASS_PATH="/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv";
    //private static final String CLASS_NAME="com.csv.com.csv.CSVCensus";
    public static void main(String[] args) throws CensusExceptions {

        StateCensusAnalyser census=new StateCensusAnalyser();
        census.readRecords(CLASS_PATH,new CSVCensus());

    }
}
