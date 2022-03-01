package com.alkemy.api.exception;

public class ParamNotFound extends RuntimeException{
    public ParamNotFound(String error) {
        super(error);
    }
}
