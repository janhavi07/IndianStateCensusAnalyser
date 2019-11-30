package com.csv.com.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    @Test
    public void givenNumberOf_Records_Match() throws CensusExceptions {
        StateCensusAnalyser analyserTest = new StateCensusAnalyser();
        int count = analyserTest.countTheRecord();
        Assert.assertEquals(37, count);
    }

    @Test
    public void throws_IOException() {
        try{
            StateCensusAnalyser analyserTest = new StateCensusAnalyser();
            int count = analyserTest.countTheRecord();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.IO_EXCEPTION,censusExceptions.type);
        }
    }

    @Test
    public void whenIncorrectFileTye_Throws_Exception() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int count = censusAnalyser.countTheRecord();
        } catch (CensusExceptions censusExceptions) {
            censusExceptions.printStackTrace();
            Assert.assertEquals(CensusExceptions.ExceptionType.INCORRECT_TYPE,censusExceptions.type);

        }
    }

}




