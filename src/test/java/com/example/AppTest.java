package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void greet_returns_default_when_name_blank() {
        assertEquals("Hello, world!", App.greet(""));
    }

    @Test
    void greet_returns_name_when_provided() {
        assertEquals("Hello, yukesh!", App.greet("yukesh"));
    }
}
