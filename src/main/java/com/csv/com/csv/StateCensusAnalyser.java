package com.csv.com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
   private static final String SAMPLE_CSV_FILE_1_PATH = "/home/admin293/Desktop/IndianStateCensus/StateCode.csv";
    private static final String SAMPLE_CSV_FILE_2_PATH ="/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv";


    public int countTheRecord1() throws CensusExceptions {
        int noOfRecordCount = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_1_PATH));
        ) {
            CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder<CSVStates>(reader)
                    .withType(CSVStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStates> csvStatesIterator = csvToBean.iterator();
            while (csvStatesIterator.hasNext()) {
                CSVStates csvStates = csvStatesIterator.next();
                noOfRecordCount++;
            }
        }catch (NullPointerException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_DELIMITER, "Incorrect delimiter given");
        }catch (RuntimeException e){
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_TYPE,
                    "Incorrect type of file,Header fle missing");
        } catch (IOException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION,
                    "File not inputed properly");}
        return noOfRecordCount;
    }

    public int countTheRecord2() throws CensusExceptions {
        int noOfRecordCount = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_2_PATH));
        ) {
            CsvToBean<CSVCensus> csvToBean = new CsvToBeanBuilder<CSVCensus>(reader)
                    .withType(CSVCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVCensus> csvCensusIterator = csvToBean.iterator();
            while (csvCensusIterator.hasNext()) {
                CSVCensus csvCensus = csvCensusIterator.next();
                noOfRecordCount++;
            }
        }catch (NullPointerException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_DELIMITER, "Incorrect delimiter given");
        }catch (RuntimeException e){
            throw new CensusExceptions(CensusExceptions.ExceptionType.INCORRECT_TYPE,
                    "Incorrect type of file,Header fle missing");
        } catch (IOException e) {
            throw new CensusExceptions(CensusExceptions.ExceptionType.IO_EXCEPTION,
                    "File not inputed properly");}
        return noOfRecordCount;
    }


}
