package io.hacksy.aoc.v2021.day04;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class Day04ProcessorTest {
    Day04Processor processor = new Day04Processor();

    @Test
    void partOne() {
        File file = FileUtil.getResourceFile("testInput/day04/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partOne(input)).isEqualTo(4512);
    }

    @Test
    void partTwo() {
        File file = FileUtil.getResourceFile("testInput/day04/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partTwo(input)).isEqualTo(1924);
    }
}