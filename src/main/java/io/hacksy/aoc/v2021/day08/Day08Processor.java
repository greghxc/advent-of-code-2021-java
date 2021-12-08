package io.hacksy.aoc.v2021.day08;


import io.vavr.collection.*;


import static io.hacksy.aoc.v2021.day08.Day08Processor.DisplayNumber.*;

public class Day08Processor {
    Integer partOne(List<String> input) {
        Set<Integer> validLengths = HashSet.of(2,4,3,7);
        return input
                .map(s -> s.split("\\|")[1].trim().split(" ")).flatMap(List::of)
                .filter(s -> validLengths.contains(s.length()))
                .size();
    }

    Integer partTwo(List<String> input) {
        return input.map(line -> {
            var readings = line.split("\\|")[0].trim().split(" ");
            var display = line.split("\\|")[1].trim().split(" ");
            var map = decode(List.of(readings));
            return List.of(display)
                    .map(this::stringToCharSet)
                    .map(set -> map.find(dn -> dn._2.equals(set)).get())
                    .map(dn -> Integer.toString(dn._1.ordinal()))
                    .foldLeft(new StringBuilder(), StringBuilder::append)
                    .toString();
        }).map(Integer::parseInt).sum().intValue();
    }

    Map<DisplayNumber, Set<Character>> decode(List<String> input) {
        List<Set<Character>> options = input.map(this::stringToCharSet);
        var one = options.find(s -> s.size() == 2).get();
        options = options.remove(one);
        var four = options.find(s -> s.size() == 4).get();
        options = options.remove(four);
        var seven = options.find(s -> s.size() == 3).get();
        options = options.remove(seven);
        var eight = options.find(s -> s.size() == 7).get();
        options = options.remove(eight);
        var three = options.filter(s -> s.size() == 5).find(s -> s.containsAll(one)).get();
        options = options.remove(three);
        var nine = options.filter(s -> s.size() == 6).find(s -> s.containsAll(three)).get();
        options = options.remove(nine);
        var zero = options.filter(s -> s.size() == 6).find(s -> s.containsAll(one)).get();
        options = options.remove(zero);
        var six = options.find(s -> s.size() == 6).get();
        options = options.remove(six);
        var five = options.find(s -> s.containsAll(nine.removeAll(one))).get();
        options = options.remove(five);
        var two = options.get();
        return HashMap.of(
                ZERO, zero, ONE, one, TWO, two, THREE, three, FOUR, four,
                FIVE, five, SIX, six, SEVEN, seven, EIGHT, eight, NINE, nine
        );
    }

    enum DisplayNumber {
        ZERO, ONE, TWO, THREE, FOUR,
        FIVE, SIX, SEVEN, EIGHT, NINE
    }

    Set<Character> stringToCharSet(String in) {
        Set<Character> charSet = HashSet.empty();
        for (char c : in.toCharArray()) {
            charSet = charSet.add(c);
        }
        return charSet;
    }
}
