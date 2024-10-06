package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @BeforeEach
    public void prepare() {
        phoneBook.add("Петя", "+7-909-999-67-55");
    }

    @ParameterizedTest
    @MethodSource("sourceAdd")
    public void testAdd(String name, String phone, int expected) {
        int result = phoneBook.add(name, phone);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceAdd() {
        return Stream.of(Arguments.of("Ирина", "+7-909-999-67-58", 2),
                Arguments.of("Петя", "+7-909-999-67-55", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceFindByNumber")
    public void testFindByNumber(String phone, String expected) {
        String result = phoneBook.findByNumber(phone);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceFindByNumber() {
        return Stream.of(Arguments.of("+7-909-999-67-50", null),
                Arguments.of("+7-909-999-67-55", "Петя")
        );
    }

    @Test
    public void testFindByName() {
        String expected = "+7-909-999-67-55";

        String result = phoneBook.findByName("Петя");

        Assertions.assertEquals(expected, result);
    }
}
