package com.csv.com.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    // private static final String SAMPLE_CSV_FILE_PATH = "/home/admin293/Desktop/IndianStateCensus/StateCode.csv";
    @Test
    public void givenNumberOf_Records_Match() throws CensusExceptions {
        StateCensusAnalyser analyserTest = new StateCensusAnalyser();
        int count = analyserTest.countTheRecord1();
        Assert.assertEquals(37, count);
    }

    @Test
    public void throws_IOException() {
        try {
            StateCensusAnalyser analyserTest = new StateCensusAnalyser();
            analyserTest.countTheRecord1();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION, censusExceptions.type);
        }
    }

    @Test
    public void whenIncorrectFileTye_Throws_Exception() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int count = censusAnalyser.countTheRecord1();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void whenIncorrectDelimiter_Throws_Exception() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.countTheRecord1();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
        }
    }

    @Test
    public void whenNoHeader_IsGiven_ThrowsException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.countTheRecord1();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void givenNumberOf_Records_Match_In_CSVFile2() throws CensusExceptions {
        StateCensusAnalyser analyserTest = new StateCensusAnalyser();
        int count = analyserTest.countTheRecord2();
        Assert.assertEquals(29, count);
    }
    @Test
    public void throws_IOException_In_CSVCensus_Data() {
        try {
            StateCensusAnalyser analyserTest = new StateCensusAnalyser();
            analyserTest.countTheRecord2();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION, censusExceptions.type);
        }
    }

    @Test
    public void whenIncorrectFileTye_Throws_Exception_in_CSVCensusData() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int count = censusAnalyser.countTheRecord2();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }





}




