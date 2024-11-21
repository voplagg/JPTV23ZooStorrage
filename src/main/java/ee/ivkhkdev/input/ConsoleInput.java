package ee.ivkhkdev.input;

import ee.ivkhkdev.interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String nextLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
