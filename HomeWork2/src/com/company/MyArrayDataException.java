package com.company;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        System.out.println("Не верные данные в ячейке: " + i + " " + j);
    }
}
