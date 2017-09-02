import java.util.Scanner;

public class CowsBulls {

    private static char[] num;

    public static void main(String[] args) {
        num = new char[4];
        seedNum();
        //System.out.println(Arrays.toString(num));
        Scanner scanner = new Scanner(System.in);
        while (!hasGuess(scanner.nextLine().toCharArray()));
        System.out.println("You win");
    }

    public static boolean hasGuess(char[] guess){
        int cows=0,bulls=0;

        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if(guess[i]==num[j]){
                    if (i==j){
                        bulls++;
                    }else {
                        cows++;
                    }
                }
            }
        }
        System.out.println(String.format("%s --> %d bulls %d cows",printGuess(guess),bulls,cows));
        if (bulls==4)return true;

        return false;
    }

    public static String printGuess(char[] guess){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < guess.length; i++) {
            buffer.append(guess[i]);
        }
        return buffer.toString();
    }



    public static void seedNum(){
        for (int i = 0; i < num.length; i++) {
            num[i]=Character.forDigit((int)(Math.random()*10),10);
        }

        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i]==num[j]){
//                    System.out.println("reseeding");
                    seedNum();
                }
            }
        }
    }
}
