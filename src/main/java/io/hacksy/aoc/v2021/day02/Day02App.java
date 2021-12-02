package io.hacksy.aoc.v2021.day02;

import io.hacksy.aoc.v2021.util.FileUtil;
import io.hacksy.aoc.v2021.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day02App {
    public static void main(String[] args) {
        var processor = new Day02Processor();

        File file = FileUtil.getResourceFile("input/day02/day02.txt");
        List<String> ints = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 02 - Part 1: %s", processor.partOne(ints)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 02 - Part 2: %s", processor.partTwo(ints)));
    }
}
