package com.ll;

public class Calc {
    public static int run(String cmd) {
        /* t1 ~ t7 */
        // expr 공백 없애기
        String expr = cmd.replace(" ", "");

        // == 기준 분리
        String[] sides = expr.split("=="); // sides = ["1+1", "2"]
        // 사칙연산자 기준 분리
        String[] tokens = sides[0].split("(?<=[+\\-*/])|(?=[+\\-*/])"); // tokens = ["1", "+", "1]

        if (tokens[1].equals("+")) {
            // 정수화
            return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
        }
        else if (tokens[1].equals("-")) {
            return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
        }
        return 0;
    }
}
