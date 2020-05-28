import controller.ConsoleInput;
import controller.InputScan;
import controller.Manager;
import view.ConsoleOutput;
import view.Printer;

import java.util.Scanner;

public class TableReservationApp {
    public static void main(String[] args) {
        InputScan inputScan = new ConsoleInput(new Scanner(System.in));
        Printer printer = new ConsoleOutput();
        Manager manager = new Manager(printer, inputScan);

        manager.manage();

    }
}
