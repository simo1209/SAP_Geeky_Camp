//package bg.simo1209.algochallenge;



import java.util.Scanner;

public class Prosvane {

    private static int n;
    private static int[] heights;

    public static void main(String[] args) {

        int result = 0;


        inputRecieve();
//        System.out.println(n);
//        System.out.println(Arrays.toString(heights));

//        result+=n-1;
        for (int i = 0; i < n -1; i++) {
            System.out.println("Current building: "+ i);
            for (int j = n-1; j > i; j--) {
                boolean increase = true;
                //TODO while with k if h(j-k) > h(i) | h(j)
                int k = j-i-1;
                System.out.println(j-i-1);
//                while(k>0){
                    if(heights[j-i-1]>heights[i] || heights[j-i-1]>j)result++;
//                    break;
//                }
//                if(j-i-1==0){result++;System.out.println();continue;}

//                if (increase)result++;

            }

        }

        System.out.println(result);
    }

    private static void inputRecieve(){
        n = 6;
        heights = new int[]{3,4,2,8,1,5};
    }

/*    private static void inputRecieve(){
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        String l = scanner.nextLine();
        heights = new int[l.split(" ").length];
        for (int i = 0; i < l.split(" ").length; i++) {
            heights[i] = Integer.parseInt(l.split(" ")[i]);
        }
    }*/
}
