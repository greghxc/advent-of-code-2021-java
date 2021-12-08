package io.hacksy.aoc.v2021.day08;

import io.hacksy.aoc.v2021.day07.Day07Processor;
import io.hacksy.aoc.v2021.util.FileUtil;
import io.hacksy.aoc.v2021.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day08App {
    public static void main(String[] args) {
        var processor = new Day08Processor();

        File file = FileUtil.getResourceFile("input/day08/day08.txt");
        List<String> ints = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 07 - Part 1: %s", processor.partOne(ints)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 07 - Part 2: %s", processor.partTwo(ints)));
    }
}
