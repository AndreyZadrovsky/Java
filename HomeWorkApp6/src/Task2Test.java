import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @ParameterizedTest
    @MethodSource("streamParams")
    void arrAfterFourTest(int[] arr, int[] result) {
        Assertions.assertArrayEquals(result, Task2.arrAfterFour(arr));
    }

    static Stream<Arguments> streamParams() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1, 2, 4, 5, 4, 1, 2, 2}, new int[]{1, 2, 2}));
        list.add(Arguments.arguments(new int[]{7, 5, 4, 5, 3, 100, 1, 1}, new int[]{5, 3, 100, 1, 1}));
        list.add(Arguments.arguments(new int[]{4}, new int[]{}));
        return list.stream();
    }

    @Test
    void testSliceException() {
        Assertions.assertThrows(RuntimeException.class, () -> Task2.arrAfterFour(new int[]{1, 2, 54, 5}));
    }

    @ParameterizedTest
    @MethodSource("streamParams2true")
    void oneAndFourTest(int[] arr) {
        Assertions.assertTrue(Task2.oneAndFour(arr));
    }

    static Stream<Arguments> streamParams2true() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1, 4, 1, 4, 1, 4, 1, 1, 4, 1, 4}));
        list.add(Arguments.arguments(new int[]{1, 4, 1, 4, 1, 4, 1, 4}));
        list.add(Arguments.arguments(new int[]{4, 1}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("streamParams2False")
    void oneAndFourTest2(int[] arr) {
        Assertions.assertFalse(Task2.oneAndFour(arr));
    }

    static Stream<Arguments> streamParams2False() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1,2,4,1,5,4,4,4,}));
        list.add(Arguments.arguments(new int[]{4,4,4,4,4,4,4,4}));
        list.add(Arguments.arguments(new int[]{1,1,1,1,1,1,1}));
        return list.stream();
    }
}