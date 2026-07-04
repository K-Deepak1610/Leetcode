class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        long low = 1;
        long high = x/2;
        while(low<=high){
            long mid = low + (high-low)/2;
            long square = mid*mid;
            if(square==x) 
                return (int) mid;
            if(square<x){
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return (int) high;
    }
}