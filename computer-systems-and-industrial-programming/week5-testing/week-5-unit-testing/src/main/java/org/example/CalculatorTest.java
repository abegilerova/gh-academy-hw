package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
    }

    @Test
    void multiply() {
        assertAll(() -> assertEquals(4, Calculator.multiply(2, 2)),
                () -> assertEquals(-4,
                        Calculator.multiply(2, -2)),
                () -> assertEquals(4,
                        Calculator.multiply(-2, -2)),
                () -> assertEquals(0,
                        Calculator.multiply(1, 0)));
    }



}
