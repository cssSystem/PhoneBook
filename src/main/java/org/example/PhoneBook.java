package org.example;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private TreeMap<String, String> phoneMap = new TreeMap<>();

    public int add(String name, String number) {
        phoneMap.put(name, number);
        return phoneMap.size();
    }

    public String findByNumber(String number) {
        return phoneMap.entrySet()
                .stream()
                .filter(v -> v.getValue().equals(number))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return phoneMap.get(name);
    }
}
