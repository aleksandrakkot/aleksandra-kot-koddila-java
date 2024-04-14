package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        // Testowanie metody add
        int resultAdd = calculator.add(5, 3);
        if (resultAdd == 8) {
            System.out.println("Test dodawania OK");
        } else {
            System.out.println("Błąd testu dodawania");
        }

        // Testowanie metody subtract
        int resultSubtract = calculator.subtract(10, 3);
        if (resultSubtract == 7) {
            System.out.println("Test odejmowania OK");
        } else {
            System.out.println("Błąd testu odejmowania");
        }
    }
}