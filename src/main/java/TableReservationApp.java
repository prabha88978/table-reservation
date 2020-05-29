import controller.ConsoleInput;
import controller.InputScan;
import controller.Manager;
import model.Restaurant;
import model.Table;
import view.ConsoleOutput;
import view.Printer;

import java.util.Scanner;

public class TableReservationApp {
    public static void main(String[] args) {
        InputScan inputScan = new ConsoleInput(new Scanner(System.in));
        Printer printer = new ConsoleOutput();
        Restaurant restaurant = getRestaurant(inputScan, printer);
        Manager manager = new Manager(printer, inputScan, restaurant);

        manager.manage();

    }

    public static Restaurant getRestaurant(InputScan inputScan, Printer printer) {
        Restaurant restaurant = new Restaurant();
        printer.numberOfTablesText();
        int numberOfTables = inputScan.readInt();
        for (int tableNumber = 0; tableNumber < numberOfTables; tableNumber++) {
            printer.numberOfSeatsText();
            int numberOfSeats = inputScan.readInt();
            Table table = new Table(numberOfSeats);
            restaurant.add(table);
        }
        return restaurant;
    }
}
