package io.hacksy.aoc.v2021.day06;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Stream;

public class Day06Processor {
    Map<Integer, Long> results = HashMap.empty();

    Long partOne(List<String> input) {
        return runFor(input, 80);
    }

    Long partTwo(List<String> input) {
        return runFor(input, 256);
    }

    Long runFor(List<String> input, int days) {
        for(int i = 0; i <= days; i++) {
            fishAndSpawnCountAfter(i);
        }
        return List.of(input.get(0).split(","))
                .map(Integer::parseInt)
                .map(i -> days + 9 - i)
                .map(this::fishAndSpawnCountAfter)
                .sum().longValue();
    }

    Long fishAndSpawnCountAfter(int days) {
        if (results.containsKey(days)) { return results.get(days).get(); }
        var total = Stream.range(0, days)
                .filter(i -> (i - 8) % 7 == 1)
                .map(i -> fishAndSpawnCountAfter(days - i))
                .sum().longValue() + 1L;
        results = results.put(days, total);
        return total;
    }
}
