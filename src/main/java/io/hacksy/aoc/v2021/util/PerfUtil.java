package io.hacksy.aoc.v2021.util;

import java.util.function.Supplier;

public class PerfUtil {
    public static void timeAndPrint(Supplier<String> stringSupplier) {
        long startTime = System.nanoTime();
        String result = stringSupplier.get();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println(String.format("Completed in %s seconds:", duration / 1_000_000_000.0));
        System.out.println(String.format(" - %s", result));
    }

    public static void timeAndPrintRepeated(int times, Supplier<String> stringSupplier) {
        long startTime = System.nanoTime();
        for (int i = 1; i < times; i++) {
            stringSupplier.get();
        }
        String result = stringSupplier.get();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println(String.format("Completed %s times in %s seconds:", times, duration / 1_000_000_000.0));
        System.out.println(String.format(" - %s", result));
    }
}
