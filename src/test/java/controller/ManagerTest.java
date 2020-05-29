package controller;

import model.Restaurant;
import model.Table;
import org.junit.Test;
import org.mockito.Mockito;
import view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.verify;

public class ManagerTest {


    @Test
    public void testShouldDisplayNoWhenThereAreNoSufficientTables() {
        Printer mockIO = Mockito.mock(Printer.class);
        InputScan inputScan = new ConsoleInput(new Scanner("2\n5\n10\n7\ny\n6\ny\n5\nn\n"));
        Restaurant restaurant = new Restaurant();
        Manager manager = new Manager(mockIO, inputScan, restaurant);

        manager.manage();

        verify(mockIO).printNotPossibleStatus();
    }

    @Test
    public void testShouldDisplayTableNumbersWhenThereAreNoSufficientTables() {
        Printer mockIO = Mockito.mock(Printer.class);
        InputScan inputScan = new ConsoleInput(new Scanner("7\ny\n6\ny\n5\nn\n"));
        Restaurant restaurant = new Restaurant();
        restaurant.add(new Table(5));
        restaurant.add(new Table(10));
        Manager manager = new Manager(mockIO, inputScan, restaurant);
        List<Integer> tableNumbers = new ArrayList<>();
        tableNumbers.add(2);

        manager.manage();

        verify(mockIO).printTables("Y", tableNumbers, 1);
    }

}
