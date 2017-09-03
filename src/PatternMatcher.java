import java.util.Scanner;
public class PatternMatcher {
    public static void main(String[] args) {
        String[] line = new Scanner(System.in).nextLine().split(" ");
        String stringIn = line[0];
        String stringPattern = line[1];
        System.out.println(patternMatcher(stringIn,stringPattern));
    }



    public static boolean patternMatcher(String stringIn,String stringPattern) {
        char[] in = stringIn.toCharArray();
        char[] pattern = stringPattern.toCharArray();

        for (int i = 0; i < in.length-pattern.length; i++) {
            boolean hasMatched = false;
            for (int j = 0; j < pattern.length; j++) {
                if(in[i+j]==pattern[j] || pattern[j]=='?'){
//                    System.out.println("match");
                    hasMatched=true;
                    continue;
                }else if(pattern[j]=='*'){
                    //TODO
                }
                else{
//                    System.out.println("fail");
                    hasMatched=false;
                    break;
                }
            }
            if (hasMatched) return true;
        }

        return false;
    }
}
