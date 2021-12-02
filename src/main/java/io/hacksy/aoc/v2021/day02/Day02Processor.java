package io.hacksy.aoc.v2021.day02;

import io.vavr.collection.List;

public class Day02Processor {
    record Position(int horizontal, int vertical, int aim) {}

    Integer partOne(List<String> input) {
        var finalPosition = input.foldLeft(new Position(0, 0, 0), (pos, instruction) -> {
            var split = instruction.split(" ");
            var cmd = split[0];
            var amount = Integer.parseInt(split[1]);

            return switch (cmd) {
                case "forward" -> new Position(pos.horizontal, pos.vertical + amount, pos.aim);
                case "up" -> new Position(pos.horizontal - amount, pos.vertical, pos.aim);
                case "down" -> new Position(pos.horizontal + amount, pos.vertical, pos.aim);
                case default -> throw new RuntimeException("Unparseable line: '" + instruction + "'");
            };
        });

        return Math.multiplyExact(finalPosition.horizontal, finalPosition.vertical);
    }

    Integer partTwo(List<String> input) {
        var finalPosition = input.foldLeft(new Position(0, 0, 0), (pos, instruction) -> {
            var split = instruction.split(" ");
            var cmd = split[0];
            var amount = Integer.parseInt(split[1]);

            return switch (cmd) {
                case "forward" -> new Position(pos.horizontal + amount, pos.vertical + (pos.aim * amount), pos.aim);
                case "up" -> new Position(pos.horizontal, pos.vertical, pos.aim - amount);
                case "down" -> new Position(pos.horizontal, pos.vertical, pos.aim + amount);
                case default -> throw new RuntimeException("Unparseable line: '" + instruction + "'");
            };
        });

        return Math.multiplyExact(finalPosition.horizontal, finalPosition.vertical);
    }
}
