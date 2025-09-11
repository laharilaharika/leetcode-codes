class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        int c=0;
        StringBuilder sb=new StringBuilder(s);
        for (int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if (ch=='(') st.push(i);
            else if(ch==')'){
                if (!st.empty()) st.pop();
                else {
                    sb.deleteCharAt(i);
                    i--;
                    c++;
                }
            }
        }
        while(!st.empty()){
                sb.deleteCharAt(st.pop());
                c++;
        }
        return c;
    }
}