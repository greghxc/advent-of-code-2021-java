package io.hacksy.aoc.v2021.day04;

import io.vavr.collection.List;
import io.vavr.collection.Map;

import java.util.Comparator;
import java.util.function.Function;

public class Day04Processor {
    private static final List<Integer> bingoMarks = List.of(
            "11111 00000 00000 00000 00000", "00000 11111 00000 00000 00000", "00000 00000 11111 00000 00000",
            "00000 00000 00000 11111 00000", "00000 00000 00000 00000 11111", "10000 10000 10000 10000 10000",
            "01000 01000 01000 01000 01000", "00100 00100 00100 00100 00100", "00010 00010 00010 00010 00010",
            "00001 00001 00001 00001 00001"
    ).map(s -> s.replace(" ", "")).map(s -> Integer.parseInt(s, 2));

    Integer partOne(List<String> input) {
        return runGame(input, results -> results.minBy(Comparator.comparing(b -> b.rounds)).get());
    }

    Integer partTwo(List<String> input) {
        return runGame(input, results -> results.maxBy(Comparator.comparing(b -> b.rounds)).get());
    }

    private Integer runGame(List<String> input, Function<List<Result>, Result> winCondition) {
        var calledNumbers = parseCalledNumbers(input);
        var cards = parseBingoCards(input);
        var winningResult = winCondition.apply(cards.map(c -> runGameForCard(c, calledNumbers)));
        return score(winningResult, calledNumbers);
    }

    private Result runGameForCard(BingoCard bingoCard, List<Integer> calledNumbers) {
        return calledNumbers.foldLeft(new Result(bingoCard, -1), (result, calledNumber) -> {
            if (isBingo(result.bingoCard())) { return result; }
            return new Result(markNumber(calledNumber, result.bingoCard()), result.rounds() + 1);
        });
    }

    private BingoCard markNumber(int number, BingoCard bingoCard) {
        return bingoCard.positionMap.get(number)
                .map(position -> new BingoCard(bingoCard.marks() | 1 << position, bingoCard.positionMap()))
                .getOrElse(bingoCard);
    }

    private boolean isBingo(BingoCard bingoCard) {
        return bingoMarks
                .find(bingoMask -> (bingoCard.marks() & bingoMask) == bingoMask)
                .isDefined();
    }

    private int score(Result result, List<Integer> calledNumbers) {
        return result.bingoCard.positionMap().keySet()
                .removeAll(calledNumbers.slice(0, result.rounds() + 1)
                .toSet()).sum().intValue() * calledNumbers.get(result.rounds());
    }

    // parsing
    private List<Integer> parseCalledNumbers(List<String> input) {
        return List.of(input.get(0).split(",")).map(Integer::parseInt);
    }

    private List<BingoCard> parseBingoCards(List<String> input) {
        return input.slice(1, input.length())
                .filter(line -> !line.isBlank())
                .flatMap(line -> List.of(line.trim().split("\\s+")))
                .map(Integer::parseInt)
                .zipWithIndex().groupBy(t -> t._2 / 25).map(t -> t._2.map(tt -> tt._1))
                .map(orderedInts -> new BingoCard(0, orderedInts.zipWithIndex().toMap(t -> t)))
                .toList();
    }

    // structs
    record BingoCard(int marks, Map<Integer, Integer> positionMap) {}
    record Result(BingoCard bingoCard, int rounds) {}
}
