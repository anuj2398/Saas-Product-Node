package com.crio.starter.exception;

public class PriceCannotBeNegativeException extends RuntimeException{
    public PriceCannotBeNegativeException(String msg){
        super(msg);
    }
}
