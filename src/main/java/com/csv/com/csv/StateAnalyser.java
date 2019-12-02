package com.csv.com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateAnalyser  {
    static CsvToBean<Object> csvToBean;
    public StateAnalyser(String file,Object object) throws CensusExceptions {
        // private static final String SAMPLE_CSV_FILE_PATH = "/home/admin293/Desktop/IndianStateCensus/StateCode.csv";
        {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(file));
                CsvToBean<Object> csvToBean= new CsvToBeanBuilder<Object>(reader)
                        .withType(Object.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                Iterator<Object> csvStatesIterator = csvToBean.iterator();
            } catch(NullPointerException e) {
                e.printStackTrace();
                throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_TYPE, "Incorrect type");
            }catch (IOException e) {
                e.printStackTrace();
                throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION,"Input output exception");
            }
        }
    }
    public int readRecords(){
        int noOfRecordCount = 0;
        Iterator<Object> csvStatesIterator = csvToBean.iterator();
        while (csvStatesIterator.hasNext()) {
            Object object = csvStatesIterator.next();
            noOfRecordCount++;
        }
        return noOfRecordCount;
    }
}
