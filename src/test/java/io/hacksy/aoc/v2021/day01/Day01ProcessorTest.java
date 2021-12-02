package io.hacksy.aoc.v2021.day01;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class Day01ProcessorTest {
    Day01Processor processor = new Day01Processor();

    @Test
    void partOne() {
        File file = FileUtil.getResourceFile("testInput/day01/input01.txt");
        List<Integer> input = FileUtil.fileToList(file);

        assertThat(processor.partOne(input)).isEqualTo(7);
    }

    @Test
    void partTwo() {
        File file = FileUtil.getResourceFile("testInput/day01/input01.txt");
        List<Integer> input = FileUtil.fileToList(file);

        assertThat(processor.partTwo(input)).isEqualTo(5);
    }
}