class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return calculatePoints(s, 'a', 'b', x, y);
        } else {
            return calculatePoints(s, 'b', 'a', y, x);
        }
    }

    private int calculatePoints(String s, char first, char second, int high, int low) {
        StringBuilder sb = new StringBuilder();
        int score = 0;

        // First pass: Remove high-value substrings (first + second)
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == first && c == second) {
                sb.deleteCharAt(len - 1); // Remove the matched pair
                score += high;
            } else {
                sb.append(c);
            }
        }

        // Second pass: Remove remaining low-value substrings (second + first)
        StringBuilder finalSb = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            int len = finalSb.length();
            if (len > 0 && finalSb.charAt(len - 1) == second && c == first) {
                finalSb.deleteCharAt(len - 1);
                score += low;
            } else {
                finalSb.append(c);
            }
        }

        return score;
    }
}