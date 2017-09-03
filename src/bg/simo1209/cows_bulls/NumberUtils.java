package bg.simo1209.cows_bulls;

import java.util.Arrays;

public class NumberUtils implements SequenceUtils {

    public char[] number;



    public NumberUtils(int digitCount) {
        this.number = new char[digitCount];
        init();
    }

    @Override
    public void init() {
        for (int i = 0; i < this.number.length; i++) {
            char newDigit = Character.forDigit((int)(Math.random()*10),10);
            while(i>0 && newDigit==this.number[i-1]){
                newDigit = Character.forDigit((int)(Math.random()*10),10);
            }
            this.number[i]=newDigit;
        }
    }



    @Override
    public int[] calcMatch(char[] guess) {
        int[] result = new int[2];
        Arrays.fill(result,0);
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < this.number.length; j++) {
                if (guess[i]==this.number[j]){
                    if (i==j){
                        result[0]++;
                    }else {
                        result[1]++;
                    }
                }
            }
        }
        return result;
    }

}
