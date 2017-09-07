package bg.simo1209.cows_bulls;

import java.util.Arrays;

public abstract class SequenceUtils {

    char[] number;

    abstract void init();

    private static AnimalCounter counter = new AnimalCounter();

    AnimalCounter calcMatch(char[] guess) {
//        int[] result = new int[2];
//        Arrays.fill(result, 0);


        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < this.number.length; j++) {
                if (guess[i] == this.number[j]) {
                    if (i == j) {
                        counter.increaseBulls(1);
                    } else {
                        counter.increaseCows(1);
                    }
                }
            }
        }
        return counter;
    }

}
