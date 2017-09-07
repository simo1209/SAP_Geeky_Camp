package bg.simo1209.cows_bulls;

import java.util.Arrays;

public class ConsoleOutput implements OutputHandler {
    @Override
    public String printMatch(char[] guess, AnimalCounter counter) {
        return String.format("%s has %d bulls and %d cows", Arrays.toString(guess),counter.getBulls(),counter.getCows());
    }
}
