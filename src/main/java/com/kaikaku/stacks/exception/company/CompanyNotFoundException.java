package com.kaikaku.stacks.exception.company;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String message){
        super(message);
    }
}
