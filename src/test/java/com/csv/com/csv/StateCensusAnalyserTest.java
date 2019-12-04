package com.csv.com.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
   StateCensusAnalyser analyserTest = new StateCensusAnalyser();
   private static final String CLASS_PATH="/home/admin293/Desktop/IndianStateCensus/StateCensusData.csv";
   private static final String CLASS_NAME="com.csv.com.csv.CSVCensus";

//    @Test
//    public void givenNumberOf_Records_Match_In_CSVStatesData()  {
//        try {
//            int count = analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.csv",new CSVstates());
//            Assert.assertEquals(37, count);
//        } catch (CensusExceptions censusExceptions) {
//            censusExceptions.printStackTrace();
//        }
//    }


//    @Test
//    public void throws_IOException_In_CSVStatesData() {
//        try {
//            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCod.csv",new CSVstates());
//        } catch (CensusExceptions censusExceptions) {
//            censusExceptions.printStackTrace();
//            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION, censusExceptions.type);
//        }
//    }
//
//    @Test
//    public void whenIncorrectFileTye_Throws_Exception_In_CSVStatesData() {
//        try {
//
//            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.pdf",new CSVstates());
//        } catch (CensusExceptions censusExceptions) {
//            censusExceptions.printStackTrace();
//            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
//
//        }
//    }
//
//    @Test
//    public void whenIncorrectDelimiter_Throws_Exception_In_CSVStatesData() {
//        try {
//            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.csv",new CSVstates());
//        } catch (CensusExceptions censusExceptions) {
//            censusExceptions.printStackTrace();
//            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
//        }
//    }
//
//    @Test
//    public void whenNoHeader_IsGiven_ThrowsException_In_CSVStatesData() {
//        try {
//            analyserTest.readRecords("/home/admin293/Desktop/IndianStateCensus/StateCode.csv", new CSVstates());
//        } catch (CensusExceptions censusExceptions) {
//            censusExceptions.printStackTrace();
//            //Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
//
//        }
//    }

    @Test
    public void givenNumberOf_RecordsShould_Match()  {
        try {
            int count =analyserTest.readRecords(CLASS_PATH, CLASS_NAME);
            Assert.assertEquals(29,count);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
        }

    }
    @Test
    public void whenFileIncorrect_Should_throw_IOException() {
        try {
            analyserTest.readRecords(CLASS_PATH, CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION, censusExceptions.type);
        }
    }

    @Test
    public void whenIncorrectFileTye_Throws_Exception_in_CSVCensusData() {
        try {
            analyserTest.readRecords(CLASS_PATH, CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void whenIncorrectDelimiter_Throws_Exception_In_CSVCensusData() {
        try {
            analyserTest.readRecords(CLASS_PATH, CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);
        }
    }

    @Test
    public void whenNoHeader_IsGiven_ThrowsException_In_CSVCensusData() {
        try {
            analyserTest.readRecords(CLASS_PATH, CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE, censusExceptions.type);

        }
    }

    @Test
    public void whenTheListIs_Sorted_AccordingTo_Density() {
        try{
            analyserTest.readRecords(CLASS_PATH,CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE,censusExceptions.type);
        }
    }

    @Test
    public void whenTheListIs_Sorted_AccordingTo_Population() {
        try{
            analyserTest.readRecords(CLASS_PATH,CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE,censusExceptions.type);
        }
    }
    @Test
    public void whenTheListIs_Sorted_AccordingTo_Area() {
        try{
            analyserTest.readRecords(CLASS_PATH,CLASS_NAME);
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE,censusExceptions.type);
        }
    }
}




