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

        for (int i = 0; i < in.length+pattern.length; i++) {
            boolean hasMatched = false;
            for (int j = 0; j < pattern.length; j++) {
                if(in[i+j]==pattern[j] || pattern[j]=='?'){
//                    System.out.println("match");
                    hasMatched=true;
                    continue;
                }else if(pattern[j]=='*'){
                    if(j>0 && pattern[j-1]=='*')return true;
                    //TODO
                    if (j== pattern.length-1 || i==in.length-1)return true;  // CASES a*(j=pat.length-1(case all) abbs (case 0)
//                    int tempI = i;
//
//                    while (in[j+i++]!=pattern[j+1])hasMatched=false;
//                    hasMatched=in[j+i-1]==pattern[j+1];
//                    i=tempI;
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
