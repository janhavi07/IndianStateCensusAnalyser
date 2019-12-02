package com.csv.com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public CsvToBean createBuilder(String file, Object object) throws CensusExceptions {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION, "Input file errow");
        }
        CsvToBean<Object> csvToBean = new CsvToBeanBuilder<Object>(reader)
                .withType(Object.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean;

    }

    public int readRecords(String file, Object object) throws CensusExceptions {

        int noOfRecordCount = 0;
        CsvToBean csvToBean = null;
        try {
            csvToBean = createBuilder(file, object);
            Iterator<Object> csvStatesIterator = csvToBean.iterator();
            while (csvStatesIterator.hasNext()) {
                object = csvStatesIterator.next();
                noOfRecordCount++;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_DELIMITER, "Incorrect header or delimiter format");
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_TYPE, "Incorrect Type");
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        }
        return noOfRecordCount;
    }
}



