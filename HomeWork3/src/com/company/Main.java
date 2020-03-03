package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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

        for (String word : productsList) {
            countProducts.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }

        // Вывод числа продуктов
        // (Key, Value)
        countProducts.forEach((word, count) -> {
            System.out.print(word + ": " + count + " ");
        });
        System.out.println();
        // Вывод списка уникальных слов
        countProducts.forEach((word, count) -> {
            if(count == 1) {
                System.out.print(word +  " ");
            }
        });
        System.out.println();

        // № 2
        Phonebook phoneBook = new Phonebook();
        phoneBook.add("Иванов","7-999-999-99-99");
        phoneBook.add("Смирнов","7-999-888-99-99");
        phoneBook.add("Кузнецов","7-999-777-99-99");
        phoneBook.add("Попов","7-999-666-99-99");
        phoneBook.add("Петров","7-999-555-99-99");
        phoneBook.add("Иванов","7-999-444-99-99");

        Set<String> allSurnames = phoneBook.getAllSurnames();
        for (String surname : allSurnames) {
            Set<String> phones = phoneBook.get(surname);
            System.out.printf("%s: %s%n", surname, phones);
        }
    }
}
