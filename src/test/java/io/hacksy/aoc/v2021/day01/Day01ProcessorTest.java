package io.hacksy.aoc.v2021.day01;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day01ProcessorTest {
    @Test
    void partOne() {
        var processor = new Day01Processor();
        List<Integer> input = List.of(1, 2, 3);
        assertThat(processor.partOne(input)).isEqualTo(null);
    }
}