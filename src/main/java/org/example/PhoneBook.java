package org.example;

import java.util.TreeMap;

public class PhoneBook {
    private TreeMap<String, String> phoneMap = new TreeMap<>();

    public int add(String name, String number) {
        phoneMap.put(name, number);
        return phoneMap.size();
    }

    public String findByNumber(String number) {
        return null;
    }
}
