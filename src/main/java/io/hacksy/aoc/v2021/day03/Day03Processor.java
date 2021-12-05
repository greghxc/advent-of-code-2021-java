package io.hacksy.aoc.v2021.day03;

import io.vavr.collection.List;

import java.util.function.Predicate;

public class Day03Processor {
    Integer partOne(List<String> input) {
        int positions = input.get(0).length();
        int result = 0;
        for (int position = 0; position < positions; position++) {
            boolean mostlySetAt = mostlySetAt(binaryStringsToInts(input), position);
            if (mostlySetAt) {
                result += 1 << position;
            }
        }
        int bitMask = (int) Math.pow(2, positions) - 1;
        return result * (result ^ bitMask);
    }

    Integer partTwo(List<String> input) {
        var oxGenRating = filterByMostCommonBit(binaryStringsToInts(input), input.get(0).length());
        var co2ScrubRating = filterByLeastCommonBit(binaryStringsToInts(input), input.get(0).length());
        return oxGenRating * co2ScrubRating;
    }

    List<Integer> binaryStringsToInts(List<String> binaryStrings) {
        return binaryStrings.map(s -> Integer.parseInt(s, 2));
    }

    Integer filterByMostCommonBit(List<Integer> input, int width) {
        for (int position = width - 1; position >= 0 && input.size() > 1; position--) {
            var thisPosition = position;
            Predicate<Integer> matcher = mostlySetAt(input, thisPosition)
                    ? i -> isSet(i, thisPosition)
                    : i -> !isSet(i, thisPosition);
            input = input.filter(matcher);
        }
        return input.get(0);
    }

    Integer filterByLeastCommonBit(List<Integer> input, int width) {
        for (int position = width - 1; position >= 0 && input.size() > 1; position--) {
            var thisPosition = position;
            Predicate<Integer> matcher = !mostlySetAt(input, thisPosition)
                    ? i -> isSet(i, thisPosition)
                    : i -> !isSet(i, thisPosition);
            input = input.filter(matcher);
        }
        return input.get(0);
    }

    boolean isSet(int i, int position) {
        return (i & (1 << (position))) > 0;
    }

    boolean mostlySetAt(List<Integer> ints, int position) {
        var setCount = ints.map(b -> b >> position)
                .map(b -> b & 1)
                .sum()
                .intValue();
        var unsetCount = ints.size() - setCount;
        return setCount >= unsetCount;
    }
}
