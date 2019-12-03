package com.csv.com.csv;

import com.opencsv.bean.CsvToBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StateAnalyserFactory{
    public static void method() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();
        ReplicaCSVStates replicaCSVStates=new ReplicaCSVStates();
        List<ReplicaCSVStates> list = new ArrayList<ReplicaCSVStates>();
        CsvToBean csvToBeanState;
        CsvToBean csvToBeanCensus;

        {
            try {
                csvToBeanState = analyser.createBuilder("/home/admin293/Desktop/IndianStateCensus/ReplicaStateCode.csv", new ReplicaCSVStates());
                Iterator<CSVstates> csvStatesIterator = csvToBeanState.iterator();
                //csvToBeanCensus=analyser.createBuilder("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv",new CSVCensus());
                //Iterator<CSVCensus> csvCensusIterator = csvToBeanState.iterator();
                while (csvStatesIterator.hasNext()) {
                    CSVstates csvStates = csvStatesIterator.next();
                    csvToBeanCensus = analyser.createBuilder("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv", new CSVCensus());
                    Iterator<CSVCensus> csvCensusIterator = csvToBeanCensus.iterator();
                    while (csvCensusIterator.hasNext()) {
                        CSVCensus csvCensus = csvCensusIterator.next();
                        if (csvStates.getStateName().equals(csvCensus.getState())) {
                            replicaCSVStates.setSrNo(csvStates.getSrNo());
                            replicaCSVStates.setStateName(csvStates.getStateName());
                            replicaCSVStates.setTIN(csvStates.getTIN());
                            replicaCSVStates.getStateCode(csvStates.getStateCode());
                            replicaCSVStates.setAreaInSqKm(csvCensus.getAreaInSqKm());
                            replicaCSVStates.setPopulation(csvCensus.getPopulation());
                            replicaCSVStates.setDensityPerSqKm(csvCensus.getDensityPerSqKm());
                            list.add(replicaCSVStates);
//                            System.out.println(csvStates.getSrNo() + " " + csvStates.getStateName() + " " + csvStates.getStateCode() + " " + csvStates.getStateCode());
//                            System.out.println(" " + csvStates.getPopulation() + " " + csvStates.getAreaInSqKm() + " " + csvStates.getDensityPerSqKm());
//                            System.out.println("------------------------------------");
//                            System.out.println("-------------------------------------");
                            break;
                        }
                    }

                }


            } catch (CensusExceptions censusExceptions) {
                censusExceptions.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StateAnalyserFactory.method();
    }

}
