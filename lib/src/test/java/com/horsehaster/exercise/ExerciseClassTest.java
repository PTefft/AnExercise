package com.horsehaster.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseClassTest {

    private static Map<String, Integer> buildExpectedAboveBelowMap(int above, int below) {
        return Map.of(ExerciseClass.ABOVE, above, ExerciseClass.BELOW, below);
    }

    private static Stream<Arguments> testAboveBelow() {
        return Stream.of(Arguments.of(Collections.emptySet(), 0, 0, 0),
                Arguments.of(List.of(7, 7, 7), 7, 0, 0),
                Arguments.of(Set.of(7, 8, 9), 8, 1, 1),
                Arguments.of(List.of(-5, -5, -6), -4, 0, 3));
    }

    @ParameterizedTest
    @MethodSource
    public void testAboveBelow(Collection<Integer> values, int comparisonValue, int expectedAbove, int expectedBelow) {
        assertEquals(buildExpectedAboveBelowMap(expectedAbove, expectedBelow), ExerciseClass.aboveBelow(values, comparisonValue));
    }

    @Test
    public void testAboveBelow_NullList() {
        assertThrows(NullPointerException.class, () -> ExerciseClass.aboveBelow(null, 4));
    }

    @Test
    public void testAboveBelow_NullValue() {
        List<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(null);
        values.add(5);
        assertThrows(IllegalArgumentException.class, () -> ExerciseClass.aboveBelow(values, 4));
    }

    private static Stream<Arguments> testStringRotation() {
        return Stream.of(
            Arguments.of("Foo", 3, "Foo"),
                Arguments.of("Foo", 6, "Foo"),
                Arguments.of("MyString", 2, "ngMyStri"),
                Arguments.of("MyString", 10, "ngMyStri"),
                Arguments.of("", 500, ""),
                Arguments.of("Foo", 1, "oFo"),
                Arguments.of("Stamos", 3, "mosSta")
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testStringRotation(String value, int rotationAmount, String expectedReturnValue) {
        assertEquals(expectedReturnValue, ExerciseClass.stringRotation(value, rotationAmount));
    }

    @Test
    public void testStringRotation_NullString() {
        assertThrows(NullPointerException.class, () -> ExerciseClass.stringRotation(null, 5));
    }

    @Test
    public void testStringRotation_NegativeRotation() {
        assertThrows(IllegalArgumentException.class, () -> ExerciseClass.stringRotation("foo", -1));
    }

}