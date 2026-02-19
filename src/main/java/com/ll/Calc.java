package com.ll;

public class Calc {
    public static int run(String expr) {
        expr = expr.trim();

        // 재귀 종료 조건: 수식에 공백이 없으면
        if (isNumber(expr)) {
            return Integer.parseInt(expr);
        }

        int index = findOuterOperator(expr, "+-");

        if (index == -1) {
            index = findOuterOperator(expr, "*/");
        }

        if (index != -1) {
            return calculateBinaryExpression(expr, index);
        }

        if (isWrappedByParentheses(expr)) {
            return run(removeOuterParentheses(expr));
        }

        if (expr.startsWith("-")) {
            return -run(expr.substring(1));
        }

        return 0;
    }

    private static boolean isNumber(String expr) {
        return !expr.contains(" ");
    }

    private static int findOuterOperator(String expr, String operators) {
        int depth = 0;

        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);

            if (c == ')') depth++;
            else if (c == '(') depth--;

            if (depth == 0 && isBinaryOperator(expr, i, operators)) {
                return i - 1;
            }
        }

        return -1;
    }

    private static boolean isBinaryOperator(String expr, int index, String operators) {
        if (index <= 0 || index >= expr.length() - 1) return false;

        char c = expr.charAt(index);

        return operators.indexOf(c) != -1
                && expr.charAt(index - 1) == ' '
                && expr.charAt(index + 1) == ' ';
    }

    private static int calculateBinaryExpression(String expr, int index) {
        String left = expr.substring(0, index);
        String right = expr.substring(index + 3);

        char operator = expr.charAt(index + 1);

        return switch (operator) {
            case '+' -> run(left) + run(right);
            case '-' -> run(left) - run(right);
            case '*' -> run(left) * run(right);
            case '/' -> run(left) / run(right);
            default -> 0;
        };
    }

    private static boolean isWrappedByParentheses(String expr) {
        return expr.startsWith("(") && expr.endsWith(")");
    }

    private static String removeOuterParentheses(String expr) {
        return expr.substring(1, expr.length() - 1);
    }
}
