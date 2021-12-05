package io.hacksy.aoc.v2021.day03;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class Day03ProcessorTest {
    Day03Processor processor = new Day03Processor();

    @Test
    void partOne() {
        File file = FileUtil.getResourceFile("testInput/day03/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partOne(input)).isEqualTo(198);
    }

    @Test
    void partTwo() {
        File file = FileUtil.getResourceFile("testInput/day03/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partTwo(input)).isEqualTo(230);
    }
}