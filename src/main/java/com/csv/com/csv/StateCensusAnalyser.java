package com.csv.com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static java.util.Collections.sort;

public class StateCensusAnalyser {
    //ArrayList<CSVCensus> censusList=new ArrayList<>();

    public CsvToBean<CSVCensus> createBuilder() throws CensusExceptions {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION, "Input file errow");
        }
        CsvToBean<CSVCensus> csvToBean = new CsvToBeanBuilder<CSVCensus>(reader)
                .withType(CSVCensus.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean;

    }

    public void readRecords(String file, Object object) throws CensusExceptions {

       // int noOfRecordCount = 0;
       // CsvToBean csvToBean = null;
        try {
            CsvToBean<CSVCensus> csvToBean = createBuilder();
            Iterator<CSVCensus> csvIterator =csvToBean.iterator();
            ArrayList<CSVCensus> censusList=new ArrayList<>();
            while (csvIterator.hasNext()) {
                CSVCensus census =csvIterator.next();
                censusList.add(census);
               //noOfRecordCount++;
            }
           toSort(censusList);
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_DELIMITER, "Incorrect header or delimiter format");
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_TYPE, "Incorrect Type");
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        }
       // return noOfRecordCount;
    }

    private void toSort(ArrayList<CSVCensus> censusList) {
        sort(censusList);
        censusList.stream().map(CSVCensus::getState).forEach(System.out::print);
    }


//    private static final String FILE_NAME="/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv";
//    public int readIntoJson(){
//        Reader reader= null;
//        try {
//            reader = Files.newBufferedReader(Paths.get(FILE_NAME));
//
//        CsvToBeanBuilder<CSVCensus> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
//        csvToBeanBuilder.withType(CSVCensus.class);
//        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//        CsvToBean<CSVCensus> csvToBean=csvToBeanBuilder.build();
//        Iterator<CSVCensus> iterator=csvToBean.iterator();
//        List<CSVCensus> csvCensuses=csvToBean.parse();
//        CSVCensus census=new CSVCensus();
//        while(iterator.hasNext()){
//
//        }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0;
    }




