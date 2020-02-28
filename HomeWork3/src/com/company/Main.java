package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // № 1
        ArrayList<String> productsList = new ArrayList<>();
        productsList.add("Хлеб");
        productsList.add("Батон");
        productsList.add("Хлеб");
        productsList.add("Помидор");
        productsList.add("Перец");
        productsList.add("Помидор");
        productsList.add("Помидор");
        productsList.add("Капуста");
        productsList.add("Свёкла");
        productsList.add("Огурец");

        // Число продуктов
        HashMap<String, Integer> countProducts = new HashMap<>();
        int count = 0;

        // Список уникальных слов
        ArrayList<String> result = new ArrayList<>();
        boolean unique = true;
        String str1;
        String str2;

        for (int i = 0; i < productsList.size(); i++){
            str1 = productsList.get(i);
            for(int j = 0; j < productsList.size(); j++){
                str2 = productsList.get(j);
                if(str1 == str2 && i != j){
                    unique = false;
                }
                if(str1 == str2){
                    count++;
                    countProducts.put(str1, count);
                }
            }
            count = 0;
            if(unique){
                result.add(str1);
            } else {
                unique = true;
            }
        }
        System.out.println(result);
        System.out.println(countProducts);

        // № 2
        Phonebook phoneBook = new Phonebook();
        phoneBook.add("Иванов","7-999-999-99-99");
        phoneBook.add("Смирнов","7-999-888-99-99");
        phoneBook.add("Кузнецов","7-999-777-99-99");
        phoneBook.add("Попов","7-999-666-99-99");
        phoneBook.add("Петров","7-999-555-99-99");
        phoneBook.add("Иванов","7-999-444-99-99");
        phoneBook.get("Иванов");
        phoneBook.get("Петров");
    }
}
