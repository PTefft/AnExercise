package com.horsehaster.exercise;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class ExerciseClass {
    public static final String ABOVE = "above";
    public static final String BELOW = "below";

    public static Map<String, Integer> aboveBelow(@Nonnull Collection<Integer> values, int comparisonValue) {
        Objects.requireNonNull(values);
        int above = 0;
        int below = 0;
        for (Integer value : values) {
            if (value == null) {
                throw new IllegalArgumentException("Argument values contained a null value");
            }
            if (value > comparisonValue) {
                above++;
            }
            else if (value < comparisonValue) {
                below ++;
            }
        }
        return Map.of(ABOVE, above, BELOW, below);
    }

    public static String stringRotation(@Nonnull String value, int rotationAmount) {
        Objects.requireNonNull(value);
        if (rotationAmount < 0) {
            throw new IllegalArgumentException("Received negative value for rotationAmount");
        }
        if (value.isEmpty()) {
            return value;
        }
        rotationAmount = rotationAmount % value.length();

        int rotationPoint = value.length() - rotationAmount;
        return value.substring(rotationPoint) + value.substring(0, rotationPoint);
    }
}
