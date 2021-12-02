package io.hacksy.aoc.v2021.day01;

import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Day01Processor {
    Integer partOne(List<Integer> input) {
        return Stream.range(1, input.size())
                .count(i -> input.get(i) > input.get(i - 1));
    }

    Integer partTwo(List<Integer> input) {
        return Stream.range(3, input.size())
                .count(i -> input.get(i) > input.get(i - 3));
    }
}
