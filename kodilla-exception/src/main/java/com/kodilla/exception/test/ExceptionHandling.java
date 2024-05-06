package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 1.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Wystąpił wyjątek: " + e.getMessage());
        } finally {
            System.out.println("Koniec programu.");
        }
    }
}