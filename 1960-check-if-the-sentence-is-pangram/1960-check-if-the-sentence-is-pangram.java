class Solution {
    public boolean checkIfPangram(String str) {
        str = str.toLowerCase();
        for (char c='a';c<='z';c++){
            if (str.indexOf(c)==-1){
                return false;
            }
        }
        return true;
    }
}