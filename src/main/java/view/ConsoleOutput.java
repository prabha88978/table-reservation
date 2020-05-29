package view;

import java.util.List;

public class ConsoleOutput implements Printer {

    @Override
    public void numberOfTablesText() {
        System.out.println("Number of tables");
    }


    @Override
    public void numberOfSeatsText() {
        System.out.println("Please enter number of seats per table");
    }

    @Override
    public void seatsRequiredText() {
        System.out.println("Number of seats required: ");
    }

    @Override
    public void displayTypeOfSeatText() {
        System.out.println("Should they be in the same table? ");
    }

    @Override
    public void printTables(List<Integer> tableNumbers, int tablesCount) {
        System.out.print("Y, ");
        int tableCount = 1;
        for (Integer tableNumber : tableNumbers) {
            if (tableCount < tablesCount)
                System.out.print("Table " + tableNumber + ", ");
            else
                System.out.print("Table " + tableNumber + "\n");
            tableCount++;
        }
    }

    @Override
    public void printNotPossibleStatus() {
        System.out.println("N");
    }

}
