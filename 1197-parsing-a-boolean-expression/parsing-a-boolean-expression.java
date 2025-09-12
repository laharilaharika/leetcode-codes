import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> opr = new Stack<>();
        Stack<Character> opd = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '!' || ch == '&' || ch == '|') {
                opr.push(ch);
            } else if (ch == '(' || ch == 'f' || ch == 't' || ch == ',') {
                // also keep commas so we can skip them later
                opd.push(ch);
            } else if (ch == ')') {
                evaluate(opr, opd);
            }
        }
        return opd.peek() == 't';
    }

    private void evaluate(Stack<Character> opr, Stack<Character> opd) {
        char op = opr.pop();
        boolean res = false;

        if (op == '&') {
            res = true;
            while (opd.peek() != '(') {
                char c = opd.pop();
                if (c == ',') continue;
                res = res && (c == 't');
            }
            opd.pop(); // remove '('
        } else if (op == '|') {
            res = false;
            while (opd.peek() != '(') {
                char c = opd.pop();
                if (c == ',') continue;
                res = res || (c == 't');
            }
            opd.pop(); // remove '('
        } else if (op == '!') {
            // only one operand for '!'
            char c;
            do { c = opd.pop(); } while (c == ','); // skip commas if any
            res = !(c == 't');
            opd.pop(); // remove '('
        }

        opd.push(res ? 't' : 'f');
    }
}
