package bg.simo1209.cows_bulls;

import java.util.Scanner;

public class ConsoleInput implements InputHandler{
    @Override
    public String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
