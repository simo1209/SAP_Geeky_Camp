package bg.simo1209.cows_bulls;

import java.util.Arrays;

public class NumberUtils extends SequenceUtils {

    public NumberUtils(int digitCount) {
        this.number = new char[digitCount];
        init();
    }

    @Override
    public void init() {
        for (int i = 0; i < this.number.length; i++) {
            char newDigit = Character.forDigit((int)(Math.random()*10),10);
            while(Arrays.asList(number).contains(newDigit)){
                newDigit = Character.forDigit((int)(Math.random()*10),10);
            }
            this.number[i]=newDigit;
        }
    }

}
