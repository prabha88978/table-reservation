package controller;

import model.Restaurant;
import org.junit.Test;
import org.mockito.Mockito;
import view.ConsoleOutput;
import view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;

public class ManagerTest {

    @Test
    public void testShouldAddTheTables() {
        Printer printer = new ConsoleOutput();
        InputScan inputScan = new ConsoleInput(new Scanner("5\n10\n"));
        Manager manager = new Manager(printer, inputScan);
        Restaurant restaurant = new Restaurant();

        manager.addTables(inputScan, 2, restaurant, printer);

        assertEquals(2, restaurant.getTableCount());
    }

    @Test
    public void testShouldDisplayNoWhenThereAreNoSufficientTables() {
        Printer mockIO = Mockito.mock(Printer.class);
        InputScan inputScan = new ConsoleInput(new Scanner("2\n5\n10\n7\ny\n6\ny\n5\nn\n"));
        Manager manager = new Manager(mockIO, inputScan);

        manager.manage();

        verify(mockIO).printNotPossibleStatus();
    }

    @Test
    public void testShouldDisplayTableNumbersWhenThereAreNoSufficientTables() {
        Printer mockIO = Mockito.mock(Printer.class);
        InputScan inputScan = new ConsoleInput(new Scanner("2\n5\n10\n7\ny\n6\ny\n5\nn\n"));
        Manager manager = new Manager(mockIO, inputScan);
        List<Integer> tableNumbers = new ArrayList<>();
        tableNumbers.add(2);

        manager.manage();

        verify(mockIO).printTables("Y", tableNumbers, 1);
    }

}
