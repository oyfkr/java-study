package codingtest.baek1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());

        long i = 1;
        while (i * i + i <= 2L * s) {
            i++;
        }

        if(s == 1) {
            System.out.println(1);
        }else {
            System.out.println(i - 1);
        }
    }
}
