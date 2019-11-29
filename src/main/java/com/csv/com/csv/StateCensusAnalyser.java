package com.csv.com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin293/Desktop/IndianStateCensus/StateCode.csv";

    public int countTheRecord() throws IOException {
        int noOfRecordCount = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder<CSVStates>(reader)
                    .withType(CSVStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStates> csvStatesIterator = csvToBean.iterator();
            while (csvStatesIterator.hasNext()) {
                CSVStates csvStates=csvStatesIterator.next();
                noOfRecordCount++; }
        } catch (IOException e) {
            e.printStackTrace(); }
        return noOfRecordCount;
    }
}
