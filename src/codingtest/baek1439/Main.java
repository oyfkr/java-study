package codingtest.baek1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cnt = 0;
        for(int i = 0; i < s.length()-1;i++) {
            if(s.charAt(i) != s.charAt(i+1)) {
                cnt++;
            }
        }

        if(cnt % 2 != 0) {
            System.out.println(cnt/2+1);
        }else {
            System.out.println(cnt / 2);
        }
    }
}
