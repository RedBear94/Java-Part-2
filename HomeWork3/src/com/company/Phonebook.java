package com.company;

import java.util.*;

public class Phonebook {
    private Map<String, Set<String>> phoneBook = new TreeMap<>();

    public Phonebook(){}
    public Phonebook(TreeMap<String, Set<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    private Set<String> getPhones(String surname) {
        // computeIfAbsent - добавит новый элемент в Map, но только в том случае, если элемент с таким ключом там отсутствует
        // (key, mappingFunction - value(s) возращаемые функцией)
        return phoneBook.computeIfAbsent(surname, key -> new HashSet<>());
        // возвращает текущее (существующее или вычисленное) значение, связанное с указанным ключом
        // в данном примере это HashSet<String>
    }

    void add(String surname, String phoneNumber){
        Set<String> phones = getPhones(surname); // phones - ссылается на ту же область памяти что значения phoneBook
        phones.add(phoneNumber);    // Добавление значений в набор телефонов в phoneBook
    }

    public Set<String> get(String surname){
        return getPhones(surname);
    }

    public Set<String> getAllSurnames() {
        // Возвращает представление карты в виде множества всех ключей: [Иванов, Кузнецов, Петров, Попов, Смирнов]
        return phoneBook.keySet();
    }
}
