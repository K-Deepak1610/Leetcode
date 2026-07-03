class Solution {
    public int countSubstrings(String s) {
       int n = s.length();
       int count = 0;

       for(int i=0;i<n;i++){
        int count1 = expand(s,i,i);
        int count2 = expand(s,i,i+1);
        count += count1 + count2;
       }
    return count;
    }
    private static int expand(String s,int left,int right){
        int count = 0;
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}