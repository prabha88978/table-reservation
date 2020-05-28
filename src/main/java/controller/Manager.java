package controller;

import model.Restaurant;
import model.Table;
import view.Printer;

import java.util.List;

public class Manager {
    private Printer printer;
    private InputScan inputScan;

    public Manager(Printer printer, InputScan inputScan) {
        this.printer = printer;
        this.inputScan = inputScan;
    }

    private static void checkThePossibilityAndDisplay(InputScan inputScan, Restaurant restaurant, Printer printer) {
        while (true) {
            printer.seatsRequiredText();
            int seatsRequired = inputScan.readInt();
            printer.displayTypeOfSeatText();
            char typeOfSeating = inputScan.readChar();
            if (restaurant.isSeatingPossible(seatsRequired, typeOfSeating)) {
                List<Integer> tables = restaurant.getSeatingTables(seatsRequired, typeOfSeating);
                printer.printTables("Y", tables, tables.size());

            } else {
                printer.printNotPossibleStatus();
                break;
            }

        }
    }

    public void addTables(InputScan inputScan, int numberOfTables, Restaurant restaurant, Printer printer) {
        for (int tableNumber = 0; tableNumber < numberOfTables; tableNumber++) {
            printer.numberOfSeatsText();
            int numberOfSeats = inputScan.readInt();
            Table table = new Table(numberOfSeats);
            restaurant.add(table);
        }
    }

    public void manage() {
        printer.numberOfTablesText();
        int numberOfTables = inputScan.readInt();
        Restaurant restaurant = new Restaurant();
        addTables(inputScan, numberOfTables, restaurant, printer);
        checkThePossibilityAndDisplay(inputScan, restaurant, printer);

    }
}
