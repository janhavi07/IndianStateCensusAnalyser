package com.csv.com.csv;

public class CensusExceptions extends Exception {
    enum ExceptionType{IO_EXCEPTION,INCORRECT_TYPE

    }
    ExceptionType type;
    public CensusExceptions(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
}
