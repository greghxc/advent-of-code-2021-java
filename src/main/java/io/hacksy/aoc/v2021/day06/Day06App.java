package io.hacksy.aoc.v2021.day06;

import io.hacksy.aoc.v2021.day05.Day05Processor;
import io.hacksy.aoc.v2021.util.FileUtil;
import io.hacksy.aoc.v2021.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day06App {
    public static void main(String[] args) {
        var processor = new Day06Processor();

        File file = FileUtil.getResourceFile("input/day06/day06.txt");
        List<String> ints = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 06 - Part 1: %s", processor.partOne(ints)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 06 - Part 2: %s", processor.partTwo(ints)));
    }
}
