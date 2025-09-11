import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (String op : operations) {
            if (op.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                int sum = a + b;
                stack.push(a);
                stack.push(b);
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else { // operand
                stack.push(Integer.parseInt(op));
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
    
}
