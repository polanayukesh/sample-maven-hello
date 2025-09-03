#DEmoproject##
package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println(greet("yukesh"));
    }

    // Pure function so we can unit-test it
    public static String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, world!";
        }
        return "Hello, " + name + "!";
    }
}
