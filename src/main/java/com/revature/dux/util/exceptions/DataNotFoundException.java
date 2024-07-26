package com.revature.dux.util.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message){
        super(message);
    }
    //could we make a separate DuckNotFoundException? for funsies?
}