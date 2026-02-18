package com.ll;

public class Calc {
    public static int run(String cmd) {
        cmd = cmd.replace(" ", "");
        if (cmd.isEmpty()) return 0;

        // 첫항 기호 붙이기 (자릿수 맞추기 위함)
        if (cmd.charAt(0) != '+' && cmd.charAt(0) != '-') {
            cmd = "+" + cmd;
        }

        // +, - 연산자 기준으로 쪼개기
        int idx = 1;
        // 숫자 or * or / 이면
        while (idx < cmd.length() && cmd.charAt(idx) != '+' && cmd.charAt(idx) != '-') {
            idx++;
        }

        String left = cmd.substring(0, idx); // *, /만 포함
        String right = cmd.substring(idx);

        // 왼쪽 항 계산
        int sum = calculate(left);
        return sum + run(right);
    }

    public static int calculate(String expr) {
        // 예외사항
        if (expr.length() < 2) {
            return 0;
        }


        // 자릿수 말고 연산자 기준으로 나누기 (모든 숫자가 일의 자리가 아님)
        char sign = expr.charAt(0);
        String body = expr.substring(1);

        int result;

        // 곱하기
        if (body.contains("*")) {
            String[] parts = body.split("\\*");
            result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
        }
        // 나누기
        else if (body.contains("/")) {
            String[] parts = body.split("/");
            result = Integer.parseInt(parts[0]) / Integer.parseInt(parts[1]);
        }
        // 그냥 숫자면
        else {
            result = Integer.parseInt(body);
        }

        return sign == '-' ? -result : result;
    }
}