package com.company;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    List<Human> phoneBook = new ArrayList<>();

    public Phonebook(List<Human> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public Phonebook(){
    }

    void add(String surname, String phoneNumber){
        this.phoneBook.add(new Human(surname, phoneNumber));
    }

    void get(String surname){
        for(int i = 0; i < phoneBook.size(); i++){
            if(surname == phoneBook.get(i).getSurname()){
                System.out.println(phoneBook.get(i).getSurname() + " " + phoneBook.get(i).getPhoneNumber());
            }
        }
    }
}
