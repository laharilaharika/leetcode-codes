class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) even.add(nums[i]);
            else odd.add(nums[i]);            
        }
        int[] res = new int[nums.length];
        int k=0, j=odd.size()-1;
        Collections.sort(even);
        Collections.sort(odd);
       for(int i=0;i<n;i+=2){
        res[i] = even.get(k++);
       }
        for(int i=1;i<n;i+=2){
        res[i] = odd.get(j--);
       }
        return res;
    }
}