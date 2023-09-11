package com.interviewprep.LLD.VendingMachine.exceptions;

/**
 * Created by subhash on 28/11/2022.
 */
public class NotFullPaidException extends RuntimeException{

    private String message;
    private long remaining;

    public NotFullPaidException(String message, long remaining) {
        this.message = message;
        this.remaining = remaining;
    }

    public long getRemaining(){
        return remaining;
    }

    @Override
    public String getMessage(){
        return message + remaining;
    }
}
