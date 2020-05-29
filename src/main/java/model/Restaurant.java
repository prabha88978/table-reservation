package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Table> tables;

    public Restaurant() {
        tables = new ArrayList<>();
    }

    public void add(Table table) {
        tables.add(table);
    }

    public int getTableCount() {
        return tables.size();
    }

    public boolean isSeatingPossible(int requestedSeat, char sameTable) {
        if (sameTable == 'n') { // change to readable
            return isSeatingPossibleOnMultipleTables(requestedSeat);
        } else {
            return isSeatingPossibleOnSameTable(requestedSeat);
        }
    }

    private boolean isSeatingPossibleOnMultipleTables(int requestedSeat) {
        int totalSeats = 0;
        for (Table table : tables) {
            if (table.getNumberOfSeats() > 0) {
                totalSeats += table.getNumberOfSeats();
                if (totalSeats >= requestedSeat)
                    return true;
            }
        }
        return false;
    }

    private boolean isSeatingPossibleOnSameTable(int requestedSeat) {
        for (Table table : tables) {
            if (table.getNumberOfSeats() >= requestedSeat && table.getNumberOfSeats() > 0)
                return true;
        }
        return false;
    }

    public List<Integer> getSeatingTables(int requestedSeats, char typeOfOrder) {
        List<Integer> tableNumbers;
        if (typeOfOrder == 'y') {
            tableNumbers = getSeatingTableNumber(requestedSeats);
        } else {
            tableNumbers = getTableNumbersForSeatingTables(requestedSeats);
        }
        return tableNumbers;
    }

    private List<Integer> getTableNumbersForSeatingTables(int requestedSeats) {
        List<Integer> tableNumbers = new ArrayList<>();
        int tableNumber = 1, totalSeats = 0;
        for (Table table : tables) {
            if (table.getNumberOfSeats() > 0) {
                totalSeats += table.getNumberOfSeats();
                table.setNumberOfSeats(0);
                tableNumbers.add(tableNumber);
                if (totalSeats >= requestedSeats) {
                    table.setNumberOfSeats(totalSeats - requestedSeats);
                    break;
                }
            }
            tableNumber++;
        }
        return tableNumbers;
    }

    private List<Integer> getSeatingTableNumber(int requestedSeats) {
        List<Integer> tableNumbers = new ArrayList<>();
        int tableNumber = 1;
        for (Table table : tables) {
            if (table.getNumberOfSeats() >= requestedSeats) {
                table.setNumberOfSeats(table.getNumberOfSeats() - requestedSeats);
                tableNumbers.add(tableNumber);
                break;
            }
            tableNumber++;
        }
        return tableNumbers;
    }

}
