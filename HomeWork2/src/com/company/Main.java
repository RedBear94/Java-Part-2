package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        String [][] myArray = new String[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                myArray[i][j] = "1";
            }
        }
        // myArray[3][0] = "A"; // NumberFormatException
        // myArray = new String[5][3]; // MyArraySizeException

        try{
            getArray4on4(myArray);
        } catch (MyArraySizeException ex){
            System.out.println(ex.getMessage());
        } catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        }

    }

    public static void getArray4on4(String [][] arrayFourOnFour) throws MyArraySizeException {
       int result = 0;
       if (arrayFourOnFour.length != 4)
           throw new MyArraySizeException("Размер массива должен быть 4 на 4", 1);
       else {
           for (int i = 0; i < arrayFourOnFour.length; i++){
               if(arrayFourOnFour[0].length != 4)
                   throw new MyArraySizeException("Размер массива должен быть 4 на 4", 1);
           }
        }
       for(int i = 0; i < 4; i++){
           for(int j = 0; j < 4; j++){
               try {
                   result += Integer.parseInt(arrayFourOnFour[i][j]);
               } catch (NumberFormatException ex){
                   throw new MyArrayDataException(i, j);
               }
           }
       }
       System.out.println(result);
    }
}
