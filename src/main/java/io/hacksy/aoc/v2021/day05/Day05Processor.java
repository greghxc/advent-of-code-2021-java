package io.hacksy.aoc.v2021.day05;

import io.vavr.collection.CharSeq;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;

public class Day05Processor {
    Integer partOne(List<String> input) {
        var clouds = input.map(this::cloudFromLine)
                .filter(cloud -> cloud.start().y() == cloud.stop().y() || cloud.start().x() == cloud.stop().x());
        return getCoverageGrid(clouds).values().filter(i -> i > 1).size();
    }

    Integer partTwo(List<String> input) {
        var clouds = input.map(this::cloudFromLine);
        return getCoverageGrid(clouds).values().filter(i -> i > 1).size();
    }

    Map<Coordinate, Integer> getCoverageGrid(List<Cloud> clouds) {
        Map<Coordinate, Integer> coverage = HashMap.empty();
        for (Cloud cloud : clouds) {
            var currentCoord = cloud.start();
            coverage = coverage.put(currentCoord, coverage.getOrElse(currentCoord, 0) + 1);
            while (!currentCoord.equals(cloud.stop())) {
                var xDiff = cloud.stop().x() - currentCoord.x();
                var yDiff = cloud.stop().y() - currentCoord.y();
                currentCoord = new Coordinate(
                        xDiff == 0 ? currentCoord.x() : currentCoord.x() + (xDiff / Math.abs(xDiff)),
                        yDiff == 0 ? currentCoord.y() : currentCoord.y() + (yDiff / Math.abs(yDiff))
                );
                coverage = coverage.put(currentCoord, coverage.getOrElse(currentCoord, 0) + 1);
            }
        }
        return coverage;
    }

    Cloud cloudFromLine(String line) {
        var coords = CharSeq.of(line.toCharArray()).split(" -> ")
                .map(s -> s.split(",").map(n -> Integer.parseInt(n.toString())))
                .map(s -> new Coordinate(s.get(0), s.get(1)));
        return new Cloud(coords.get(0), coords.get(1));
    }

    record Coordinate(int x, int y) {}
    record Cloud(Coordinate start, Coordinate stop) {}
}
