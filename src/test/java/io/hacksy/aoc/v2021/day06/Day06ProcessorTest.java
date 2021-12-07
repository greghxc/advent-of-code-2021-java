package io.hacksy.aoc.v2021.day06;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day06ProcessorTest {
    Day06Processor processor = new Day06Processor();

    @Test
    void partOne1() {
        File file = FileUtil.getResourceFile("testInput/day06/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partOne(input)).isEqualTo(5934);
    }

    @Test
    void partOne2() {
        File file = FileUtil.getResourceFile("testInput/day06/input02.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partOne(input)).isEqualTo(768);
    }

    @Test
    void partTwo() {
        File file = FileUtil.getResourceFile("testInput/day06/input02.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partTwo(input)).isEqualTo(26984457539L);
    }
}