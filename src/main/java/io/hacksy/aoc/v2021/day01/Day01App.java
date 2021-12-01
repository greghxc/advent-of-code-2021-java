package io.hacksy.aoc.v2021.day01;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.hacksy.aoc.v2021.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day01App {
    public static void main(String[] args) {
        var processor = new Day01Processor();

        File file = FileUtil.getResourceFile("input/day01/day01.txt");
        List<Integer> ints = FileUtil.fileToList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 01 - Part 1: %s", processor.partOne(ints)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 01 - Part 2: %s", processor.partTwo(ints)));
    }
}
