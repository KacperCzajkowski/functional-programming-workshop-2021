package pl.allegrotech.functionalprogramming.exercises.exercise2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise2 {

    private static final List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
    private static final List<String> words = List.of("one", "two", "three", "four", "five", "six");
    private static final List<String> fruits = List.of("apple", "cranberry", "blueberry", "blackberry");

    @Test
    public void shouldTestCollect() {
        // given / when
        List<String> expectedNumberList = List.of("2", "4", "6");
        List<String> expectedWordsList = List.of("one", "two", "six");
        List<String> expectedFruitsList = List.of("cranberry", "blueberry", "blackberry");

        List<String> result1 = Predicates.collect(numbers, expectedNumberList::contains);
        List<String> result2 = Predicates.collect(words, expectedWordsList::contains);
        List<String> result3 = Predicates.collect(fruits, expectedFruitsList::contains);

        // then
        assertEquals(expectedNumberList, result1);
        assertEquals(expectedWordsList, result2);
        assertEquals(expectedFruitsList, result3);
    }

    static class Predicates {

        public static <T> List<T> collect(Collection<T> collection, Predicate<T> predicate) {
            return collection.stream().filter(predicate).collect(Collectors.toList());
        }
    }

}

