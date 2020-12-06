package com.cg.dealsdateadminmicroservice.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String msg){
        super(msg);
    }

}
