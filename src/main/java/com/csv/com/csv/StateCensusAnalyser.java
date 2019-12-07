package com.csv.com.csv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class StateCensusAnalyser {
    ArrayList<CSVCensus> censusList = new ArrayList<>();

    public CsvToBean<CSVCensus> createBuilder() throws CensusExceptions {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv"));
        } catch (IOException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION, "Input file errow");
        }
        CsvToBean<CSVCensus> csvToBean = new CsvToBeanBuilder<CSVCensus>(reader)
                .withType(CSVCensus.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean;

    }

    public int readRecords(String file, Object object) throws CensusExceptions {

         int noOfRecordCount = 0;
        try {
            CsvToBean<CSVCensus> csvToBean = createBuilder();
            Iterator<CSVCensus> csvIterator = csvToBean.iterator();
//            ArrayList<CSVCensus> censusList = new ArrayList<>();
            while (csvIterator.hasNext()) {
                CSVCensus census = csvIterator.next();
                censusList.add(census);
                noOfRecordCount++;
            }
            toSortAccordingToArea(censusList);
            boolean write=writeToGson(censusList);
        } catch (NullPointerException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_DELIMITER, "Incorrect header or delimiter format");
        } catch (RuntimeException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_TYPE, "Incorrect Type");
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        } catch (IOException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION,"Wrong file input");
        }
         return noOfRecordCount;
    }


    public ArrayList<CSVCensus> toIterate(CsvToBean<CSVCensus> csvToBean){
        Iterator<CSVCensus> csvIterator = csvToBean.iterator();
        while (csvIterator.hasNext()) {
            CSVCensus census = csvIterator.next();
            censusList.add(census);
        }
        return censusList;
    }

    private boolean writeToGson(ArrayList<CSVCensus> censusList) throws IOException {
        String SAMPLE_JSON_FILE_PATH="/home/admin293/Desktop/IndianStateCensus/StateCensusDataJson.json";
        Gson gson=new Gson();
        String json=gson.toJson(censusList);
        FileWriter writer=new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        return true;
    }

    public void sorting(String file, Object object,String fieldToSort) throws CensusExceptions {
        CsvToBean<CSVCensus> csvToBean = null;
        try {
            csvToBean = createBuilder();
            ArrayList<CSVCensus> censusList =toIterate(csvToBean);
            if(fieldToSort.contains("State"))
                toSortAccordingToState(censusList);
            else if (fieldToSort.contains("Density"))
                toSortAccordingToDensity(censusList);
            else if(fieldToSort.contains("Population"))
               toSortAccordingToPopulation(censusList);
            else if(fieldToSort.contains("Area"))
                toSortAccordingToPopulation(censusList);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        }
        try {
            writeToGson(censusList);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION,"Wrong file input");
        }
    }
    private void toSortAccordingToState(ArrayList<CSVCensus> censusList) throws CensusExceptions {
        Comparator<CSVCensus> c = (s1, s2) -> s1.getState().compareTo(s2.getState());
        censusList.sort(c);
        try {
            writeToGson(censusList);
        } catch (IOException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION,"Wrong file input");
        }

    }

    private void toSortAccordingToDensity(ArrayList<CSVCensus> censusList) {
        Comparator<CSVCensus> c = (s1, s2) -> s1.getDensityPerSqKm().compareTo(s2.getDensityPerSqKm());
        Collections.sort(censusList, reverseOrder());

    }

    private void toSortAccordingToPopulation(ArrayList<CSVCensus> censusList) {
        Comparator<CSVCensus> c = (s1, s2) -> s1.getPopulation().compareTo(s2.getPopulation());
        Collections.sort(censusList, reverseOrder());

    }

    private void toSortAccordingToArea(ArrayList<CSVCensus> censusList) {
        Comparator<CSVCensus> c = (s1, s2) -> s1.getAreaInSqKm().compareTo(s2.getAreaInSqKm());
        Collections.sort(censusList, reverseOrder());
    }


}




