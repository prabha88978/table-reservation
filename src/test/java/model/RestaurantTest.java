package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class RestaurantTest {

    @Test
    public void testShouldGetTheCountTheTables(){
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);

        int expected = restaurant.getTableCount();

        assertEquals(expected,2);
    }

    @Test
    public void testShouldReturnTrueIfThereIsAPossibilityToSitOnSameTable() {
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);

        boolean expected = restaurant.isSeatingPossible(15, 'y');

        assertTrue(expected);

    }

    @Test
    public void testShouldReturnFalseIfThereIsNoAPossibilityTpSitOnSameTable() {
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);

        boolean expected = restaurant.isSeatingPossible(18, 'y');

        assertFalse(expected);
    }


    @Test
    public void testShouldReturnTrueIfThereIsAPossibilityToSitOnDifferentTables() {
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);

        boolean expected = restaurant.isSeatingPossible(23, 'n');

        assertTrue(expected);

    }

    @Test
    public void testShouldReturnFalseIfThereIsNoAPossibilityToSitOnDifferentTables() {
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);

        boolean expected = restaurant.isSeatingPossible(33, 'n');

        assertFalse(expected);
    }

    @Test
    public void testShouldReturnListOfTablesWhenThereIsAPossibilityToSitOnSameTable() {
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);
        List<Integer> expectedTables = new ArrayList<>();
        expectedTables.add(2);

        boolean expectedBooking = restaurant.isSeatingPossible(13, 'y');
        List<Integer> actualTables = restaurant.getSeatingTables(13, 'y');

        assertTrue(expectedBooking);
        assertEquals(expectedTables, actualTables);
    }

    @Test
    public void testShouldReturnListOfTablesWhenThereIsAPossibilityToSitOnDifferentTables() {
        Table table = new Table(10);
        Table anotherTable = new Table(15);
        Table thirdTable = new Table(13);
        Restaurant restaurant = new Restaurant();
        restaurant.add(table);
        restaurant.add(anotherTable);
        restaurant.add(thirdTable);
        List<Integer> expectedTables = new ArrayList<>();
        expectedTables.add(1);
        expectedTables.add(2);
        expectedTables.add(3);

        boolean expectedBooking = restaurant.isSeatingPossible(33, 'n');
        List<Integer> actualTables = restaurant.getSeatingTables(33, 'n');

        assertTrue(expectedBooking);
        assertEquals(expectedTables, actualTables);
    }


}
