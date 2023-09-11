package com.interviewprep.LLD.VendingMachine.exceptions;

/**
 * Created by subhash on 28/11/2022.
 */
public class NotSufficientChangeException extends RuntimeException {

    private String message;

    public NotSufficientChangeException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
