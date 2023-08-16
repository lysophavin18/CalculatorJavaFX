package com.example.demo;

public class Model {
    public float calculator(long number1, long number2, String operator) {
        switch (operator) {
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0)
                    return 0;
                return (float) number1 / number2;
            case "+":
                return number1 + number2;
            case "c":
                return 0; // Clear the result
            default:
                return 0;
        }
    }
}
