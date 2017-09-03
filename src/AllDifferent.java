import java.util.Arrays;
import java.util.Scanner;

public class AllDifferent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(allDifferent(s));
    }

    public static boolean allDifferent(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; ++i) {
            if (chars[i]==chars[i+1]) return false;
        }
        return true;
    }
}
