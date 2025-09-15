class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[heights.length];

        for(int i=heights.length-1; i>=0; i--){
            while(!st.isEmpty() && heights[i]>st.peek()){
                ans[i]++;
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]++;
            }
            st.push(heights[i]);
        }
        return ans;
    }
}