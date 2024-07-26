package com.revature.dux.util.aspects;

import com.revature.dux.util.exceptions.DataNotFoundException;
import com.revature.dux.util.exceptions.DuckNotFoundException;
import com.revature.dux.util.exceptions.InvalidInputException;
import com.revature.dux.util.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class ExceptionAspect {
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404 status code
    public String dataNotFound(DataNotFoundException dnf){
        return dnf.getMessage();
    }

    @ExceptionHandler(DuckNotFoundException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT) // 418 status code
    public String duckNotFound(DuckNotFoundException dnf){
        return dnf.getMessage();
    }

    @ExceptionHandler({UnauthorizedException.class, AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401 status code
    public String authHandler(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler({InvalidInputException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE) // 406 status code
    public String invalidInput(Exception i){
        return i.getMessage();
    }

    //TODO this is a generic catch-all that we can get rid of
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 status code
    public String devDidSomethingWrong(Exception e){
        return e.getMessage();
    }
}
