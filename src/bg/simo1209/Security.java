package bg.simo1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Security {
    public static void main(String[] args) throws IOException {
        long pass = 0;
        String line;
        while((line=new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"/home/simo09/Programming/Java/GeekyCampHomework/src/bg/simo1209/a.out",String.valueOf(pass++)}).getInputStream())).readLine())!="Correct\n");
        System.out.println(pass);
    }
}
