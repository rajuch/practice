package leetcode.contest33;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-33/problems/fraction-addition-and-subtraction/
 */
public class FractionAdditionAndSubstraction {

    private String calculate(String operand1, String operand2, char op) {
        String[] tokens = operand1.split("/");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        tokens = operand2.split("/");
        int c = Integer.parseInt(tokens[0]);
        int d = Integer.parseInt(tokens[1]);

        String res = "";
        if (b == d) {
            if (op == '-') {
                res += (a-c) + "/" + d;
            }
            if (op == '+') {
                res += (a+c) + "/" + d;
            }
        } else {

        }
        return "";
    }

    public String fractionAddition(String expression) {
        String operand1 = "", operand2 = "";
        char operation = '\0';
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            if (operand1 != "" && operand2 != "" && operation != '\0') {
                operand1 = calculate(operand1, operand2, operation);
                operand2 = "";
            }
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                operation = expression.charAt(i);
            }
            if (operation != '\0') {
                operand1 += expression.charAt(i);
            } else {
                operand2 += expression.charAt(i);
            }

        }
        return "";
    }

    public static void main(String[] args) {
        FractionAdditionAndSubstraction obj = new FractionAdditionAndSubstraction();
        System.out.println(obj.fractionAddition(""));
    }
}
