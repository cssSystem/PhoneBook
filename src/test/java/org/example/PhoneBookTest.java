package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    @ParameterizedTest
    @MethodSource("sourceAdd")
    public void testAdd(String name, String phone, int expected) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петя", "+7-909-999-67-55");
        int result = phoneBook.add(name, phone);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceAdd() {
        return Stream.of(Arguments.of("Ирина", "+7-909-999-67-58", 2),
                Arguments.of("Петя", "+7-909-999-67-55", 1)
        );
    }
}
