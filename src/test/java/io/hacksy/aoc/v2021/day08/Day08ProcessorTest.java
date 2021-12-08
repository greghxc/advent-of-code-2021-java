package io.hacksy.aoc.v2021.day08;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day08ProcessorTest {
    Day08Processor processor = new Day08Processor();

    @Test
    void partOne() {
        File file = FileUtil.getResourceFile("testInput/day08/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partOne(input)).isEqualTo(26);
    }

    @Test
    void partTwo() {
        File file = FileUtil.getResourceFile("testInput/day08/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partTwo(input)).isEqualTo(61229);
    }
}