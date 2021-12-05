package io.hacksy.aoc.v2021.util;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import java.util.stream.Collector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilTest {

    @Test
    void partition() {
        var result = CollectionUtil.partition(List.of(1,2,3,4,5,6,7,8,9), 3);
        assertThat(result).isEqualTo(List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7,8,9)
        ));
    }
}