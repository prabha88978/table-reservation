package view;

import java.util.List;

public interface Printer {
    void numberOfTablesText();

    void numberOfSeatsText();

    void seatsRequiredText();

    void displayTypeOfSeatText();

    void printTables(String possibility, List<Integer> tableNumbers, int tablesCount);

    void printNotPossibleStatus();


}
