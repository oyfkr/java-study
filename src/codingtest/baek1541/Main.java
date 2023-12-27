package codingtest.baek1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] split = s.split("-");

        int answer = Integer.MAX_VALUE;

        for (String value : split) {

            String[] split1 = value.split("\\+");

            int tmp = 0;
            for (String string : split1) {
                tmp += Integer.parseInt(string);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = tmp;
            } else {
                answer -= tmp;
            }
        }
        System.out.println(answer);
    }
}
