package codingtest.floordecoration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static Tree[][] room;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ga = Integer.parseInt(st.nextToken());
        int se = Integer.parseInt(st.nextToken());

        room = new Tree[ga][se];

        for(int i = 0; i < ga; i++){
            String s = br.readLine();
            for(int j = 0; j< se; j++){
                room[i][j] = new Tree();
                room[i][j].setPattern(s.charAt(j));

            }
        }


        check();
        System.out.println(count);
    }


    public static void check() {

        for(int i = 0; i< room.length; i++) {
            for(int j = 0; j < room[0].length; j++) {
                if(!room[i][j].getFlag()) {
                    if(Objects.equals(room[i][j].getPattern(), '-')) {
                        count++;
                        room[i][j].changeFlagTrue();
                        if(j+1 == room[0].length) {
                            continue;
                        }
                        checkGa(i,j+1);
                    }
                    if(Objects.equals(room[i][j].getPattern(), '|')) {
                        count++;
                        room[i][j].changeFlagTrue();
                        if(i+1 == room.length) {
                            continue;
                        }
                        checkSe(i+1,j);
                    }
                }
            }
        }
    }

    public static void checkGa(int i, int j) {

        if(room[i][j].getPattern().equals('-')) {
            room[i][j].changeFlagTrue();
            if(j+1 == room[0].length) {
                return;
            }
            checkGa(i, j+1);
        }
    }

    public static void checkSe(int i, int j) {

        if(room[i][j].getPattern().equals('|')) {
            room[i][j].changeFlagTrue();
            if(i+1 == room.length) {
                return;
            }
            checkSe(i+1, j);
        }
    }

    static class Tree {
        Character pattern;
        boolean flag = false;

        private void setPattern(Character pattern) {
            this.pattern = pattern;
        }

        private void changeFlagTrue() {
            this.flag = true;
        }
        private boolean getFlag() {
            return this.flag;
        }
        private Character getPattern() {
            return this.pattern;
        }
    }
}
