package org.example;

public class FizzBuzz {
    public static String translate(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        }
        return "";
    }
}
