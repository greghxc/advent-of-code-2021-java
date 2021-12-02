package io.hacksy.aoc.v2021.day02;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day02ProcessorTest {
    Day02Processor processor = new Day02Processor();

    @Test
    void partOne() {
        File file = FileUtil.getResourceFile("testInput/day02/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partOne(input)).isEqualTo(150);
    }

    @Test
    void partTwo() {
        File file = FileUtil.getResourceFile("testInput/day02/input01.txt");
        List<String> input = FileUtil.fileToStringList(file);

        assertThat(processor.partTwo(input)).isEqualTo(900);
    }
}