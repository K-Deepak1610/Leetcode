class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int w:weights){
            low = Math.max(low,w);
            high += w;
        }
        int ans = high;
        while(low<=high){
            int cap = low +(high-low)/2;
            if(canShift(weights,days,cap)){
                ans = cap;
                high = cap-1;
            }
            else{
                low = cap + 1;
            }
        }
        return ans;
    }
    private static boolean canShift(int weights[],int days,int cap){
        int d = 1;
        int curr = 0;
        for(int w:weights){
            if(curr+w>cap){
                d++;
                curr = w;
            }
            else{
                curr += w;
            }
        }
        return d<=days;
    }
}