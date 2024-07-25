package com.revature.dux.util.exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message); // the constructor from the inherited class above
    }
}
