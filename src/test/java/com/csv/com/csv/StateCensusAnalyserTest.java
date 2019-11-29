package com.csv.com.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    @Test
    public void givenNumberOf_Records_Match() {
        try {
            StateCensusAnalyser analyserTest = new StateCensusAnalyser();
            int count=analyserTest.countTheRecord();
            Assert.assertEquals(37,count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
