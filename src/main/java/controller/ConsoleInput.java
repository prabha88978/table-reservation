package controller;

import java.util.Scanner;

public class ConsoleInput implements InputScan {
    private Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public char readChar() {
        return scanner.next().charAt(0);
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }
}
