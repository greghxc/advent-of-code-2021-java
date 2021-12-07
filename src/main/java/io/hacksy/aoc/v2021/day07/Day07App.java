package io.hacksy.aoc.v2021.day07;

import io.hacksy.aoc.v2021.day06.Day06Processor;
import io.hacksy.aoc.v2021.util.FileUtil;
import io.hacksy.aoc.v2021.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day07App {
    public static void main(String[] args) {
        var processor = new Day07Processor();

        File file = FileUtil.getResourceFile("input/day07/day07.txt");
        List<String> ints = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 07 - Part 1: %s", processor.partOne(ints)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 07 - Part 2: %s", processor.partTwo(ints)));
    }
}
