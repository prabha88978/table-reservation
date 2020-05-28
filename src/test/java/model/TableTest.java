package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableTest {

    @Test
    public void testShouldReturnNumberOfSeatsOfATable() {
        Table table = new Table(10);
        int expectedNumberOfSeats = 10;

        int actualNumberOfSeats = table.getNumberOfSeats();

        assertEquals(expectedNumberOfSeats, actualNumberOfSeats);
    }

    @Test
    public void testShouldSetTheNumberOfSeatsForTable() {
        Table table = new Table(10);
        int expectedSetNumber = 245;

        table.setNumberOfSeats(245);
        int actualSetNumber = table.getNumberOfSeats();

        assertEquals(expectedSetNumber, actualSetNumber);

    }
}
