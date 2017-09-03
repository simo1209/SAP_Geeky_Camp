package bg.simo1209.cows_bulls;

import java.util.Arrays;

public class ConsoleOutput implements OutputHandler {
    @Override
    public String printMatch(char[] guess, int[] result) {
        return String.format("%s has %d bulls and %d cows", Arrays.toString(guess),result[0],result[1]);
    }
}
