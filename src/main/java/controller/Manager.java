package controller;

import model.Restaurant;
import view.Printer;

import java.util.List;

public class Manager {
    private Printer printer;
    private InputScan inputScan;
    private Restaurant restaurant;

    public Manager(Printer printer, InputScan inputScan, Restaurant restaurant) {
        this.printer = printer;
        this.inputScan = inputScan;
        this.restaurant = restaurant;
    }

    private void checkThePossibilityAndDisplay() {
        while (true) {
            printer.seatsRequiredText();
            int seatsRequired = inputScan.readInt();
            printer.displayTypeOfSeatText();
            char typeOfSeating = inputScan.readChar();
            if (restaurant.isSeatingPossible(seatsRequired, typeOfSeating)) {
                List<Integer> tables = restaurant.getSeatingTables(seatsRequired, typeOfSeating);
                printer.printTables(tables, tables.size());

            } else {
                printer.printNotPossibleStatus();
                break;
            }
        }
    }

    public void manage() {
        checkThePossibilityAndDisplay();
    }
}
