package controller;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConsoleInputTest {

    @Test
    public void testShouldReturnTheCharacter() {
        InputScan inputScan = new ConsoleInput(new Scanner("n"));
        char expected = 'n';
        char actual = inputScan.readChar();

        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnTheMisMatchedCharacter() {
        InputScan inputScan = new ConsoleInput(new Scanner("n"));
        char expected = 'p';
        char actual = inputScan.readChar();

        assertNotEquals(expected, actual);
    }

    @Test
    public void testShouldReturnTheInteger() {
        InputScan inputScan = new ConsoleInput(new Scanner("10"));
        int expected = 10;

        int actual = inputScan.readInt();

        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnMisMatchedInteger() {
        InputScan inputScan = new ConsoleInput(new Scanner("10"));
        int expected = 100;

        int actual = inputScan.readInt();

        assertNotEquals(expected, actual);
    }
}
