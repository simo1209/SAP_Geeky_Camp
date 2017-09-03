import java.util.Scanner;

public class SequenceMax {
    public static void main(String[] args) {
        System.out.println(sequenceMax(new Scanner(System.in).nextLine()));
    }

    public static int sequenceMax(String s){
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; ++i) {
            int index = 0;
            for (int k = i; k < chars.length; k++) {
                if (chars[i]==chars[k]){
                    ++index;
                }else{
                    break;
                }
            }
            if (index>max){
                max=index;
            }
        }
        return max;
    }
}