package demoShop.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class test {

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana"})
    @NullSource
    @NullAndEmptySource
    void testWithMultipleSources(String dsad) {
        System.out.println("Input: " + dsad);
    }

    enum Fruit {
        APPLE, BANANA, CHERRY
    }

    @ParameterizedTest
    @EnumSource(Fruit.class)
    void testEnums(Fruit fruit) {
        System.out.println("Fruit: " + fruit);
    }

    @ParameterizedTest
    @EnumSource(value = Fruit.class, names = {"APPLE", "CHERRY"})
    void testSpecificEnums(Fruit fruit) {
        System.out.println("Selected fruit: " + fruit);
    }

    static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of("apple", 1),
                Arguments.of("banana", 2),
                Arguments.of("cherry", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForTest")
    void testWithMethodSource(String fruit, int number) {
        System.out.println(fruit + " has number " + number);
    }
}
