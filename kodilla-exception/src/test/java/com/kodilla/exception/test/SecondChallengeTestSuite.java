package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTest {

    private final SecondChallenge secondChallenge = new SecondChallenge();

    @Test
    void shouldThrowExceptionWhenXIsEqualTo2() {
        // given
        double x = 2.0;
        double y = 1.0;

        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x, y));
    }

    @Test
    void shouldThrowExceptionWhenXIsGreaterThan2() {
        // given
        double x = 3.0;
        double y = 1.0;

        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x, y));
    }

    @Test
    void shouldThrowExceptionWhenXIsLessThan1() {
        // given
        double x = 0.9;
        double y = 1.0;

        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x, y));
    }

    @Test
    void shouldThrowExceptionWhenYIsEqualTo1_5() {
        // given
        double x = 1.0;
        double y = 1.5;

        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x, y));
    }
}