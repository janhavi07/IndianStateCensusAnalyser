package com.csv.com.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
   StateCensusAnalyser analyserTest = new StateCensusAnalyser();

    @Test
    public void givenNumberOf_Records_Match_In_CSVStatesData()  {
        try {
            int count = analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.csv",new CSVstates());
            Assert.assertEquals(37, count);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        }
    }


    @Test
    public void throws_IOException_In_CSVStatesData() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCod.csv",new CSVstates());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION, censusExceptions.type);
        }
    }

    @Test
    public void whenIncorrectFileTye_Throws_Exception_In_CSVStatesData() {
        try {

            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.pdf",new CSVstates());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void whenIncorrectDelimiter_Throws_Exception_In_CSVStatesData() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.csv",new CSVstates());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
        }
    }

    @Test
    public void whenNoHeader_IsGiven_ThrowsException_In_CSVStatesData() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.csv", new CSVstates());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            //Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void givenNumberOf_Records_Match_In_CSVCensusData()  {
        try {
           int count = analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv", new CSVCensus());
            Assert.assertEquals(29, count);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        }

    }
    @Test
    public void throws_IOException_In_CSVCensus_Data() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCensusDat.csv",new CSVCensus());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION, censusExceptions.type);
        }
    }

    @Test
    public void whenIncorrectFileTye_Throws_Exception_in_CSVCensusData() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCensusData.pdf",new CSVCensus());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void whenIncorrectDelimiter_Throws_Exception_In_CSVCensusData() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv", new CSVCensus());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
        }
    }

    @Test
    public void whenNoHeader_IsGiven_ThrowsException_In_CSVCensusData() {
        try {
            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv", new CSVCensus());
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

}




