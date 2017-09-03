import java.util.Arrays;
import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
//        String s = new Scanner(System.in).nextLine();
//        System.out.println("Result here");

        System.out.println(digitCount(new Scanner(System.in).nextLine()));
    }

    public static String digitCount(String s){
        String[] digits = s.split(" ");
        String[] copy = s.split(" ");
        String[] nonRepeated = new String[digits.length];
        int index = 0;
        for (int i = 0; i < digits.length; ++i) {
            boolean shouldDelete = false;
            for (int j = 0; j < nonRepeated.length; j++) {
                if (digits[i].equals(nonRepeated[j])){
                    shouldDelete=true;
                }
            }
            if(shouldDelete){
                digits[i]=null;
            }else{
                nonRepeated[index++]=digits[i];
            }
        }

        String[] right = new String[index];
        index = 0;

        for (int i = 0; i < right.length; ++i) {
            right[i]=nonRepeated[i];
        }

        int[] count = new int[right.length];
        Arrays.fill(count,0);
        for (int i = 0; i < copy.length; ++i) {
            for (int j = 0; j < right.length; j++) {
                if (copy[i].equals(right[j])){
                    count[j]++;
                }
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < right.length; ++i) {
            buffer.append(String.format("%s %d ",right[i],count[i]));
        }
        return buffer.toString().trim();
    }
}
