package io.hacksy.aoc.v2021.day04;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.hacksy.aoc.v2021.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day04App {
    public static void main(String[] args) {
        var processor = new Day04Processor();

        File file = FileUtil.getResourceFile("input/day04/day04.txt");
        List<String> ints = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 04 - Part 1: %s", processor.partOne(ints)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 04 - Part 2: %s", processor.partTwo(ints)));
    }
}
