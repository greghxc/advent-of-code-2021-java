package io.hacksy.aoc.v2021.day07;

import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Day07Processor {
    Integer partOne(List<String> input) {
        List<Integer> positions = List.of(input.get(0).split(",")).map(Integer::parseInt);
        List<Integer> meetPositions = Stream.range(positions.min().get(), positions.max().get() + 1).toList();
        return meetPositions
                .map(i -> positions
                        .map(p -> Math.abs(p - i))
                        .sum().intValue()
                ).min().get();
    }

    Integer partTwo(List<String> input) {
        List<Integer> positions = List.of(input.get(0).split(",")).map(Integer::parseInt);
        List<Integer> meetPositions = Stream.range(positions.min().get(), positions.max().get() + 1).toList();
        return meetPositions
                .map(i -> positions
                        .map(p -> (Math.abs(p - i) / 2.0) * (1 + Math.abs(p - i)))
                        .sum().intValue()
                ).min().get();
    }

}
