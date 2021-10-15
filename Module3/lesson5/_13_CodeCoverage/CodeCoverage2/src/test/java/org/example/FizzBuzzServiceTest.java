package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzServiceTest {
    private FizzBuzzService fizzBuzzService;

    @BeforeEach
    void init() {
        fizzBuzzService = new FizzBuzzService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 33})
    public void fizzBuzz_multipleThreeNotFive_returnsFizz(int n) {
        assertEquals("Fizz", fizzBuzzService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 55})
    public void fizzBuzz_multipleFiveNotThree_returnsBuzz(int n) {
        assertEquals("Buzz", fizzBuzzService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 225, 3375})
    public void fizzBuzz_multipleThreeAndFive_returnsFizzBuzz(int n) {
        assertEquals("FizzBuzz", fizzBuzzService.fizzBuzz(n));
    }

}
