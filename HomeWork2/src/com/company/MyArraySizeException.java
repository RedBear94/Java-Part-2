package com.company;

public class MyArraySizeException extends Exception{
    private int number;
    public int getNumber(){
        return number;
    }

    public MyArraySizeException(String message, int num){
        super(message);
        number=num;
    }
}
