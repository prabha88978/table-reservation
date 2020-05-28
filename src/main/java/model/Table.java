package model;

public class Table {
    private int numberOfSeats;

    public Table(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    int getNumberOfSeats() {
        return numberOfSeats;
    }

    void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
