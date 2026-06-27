class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum = curSum + nums[i];
            if(sum < nums[i]){
                curSum = nums[i];
            }
            else{
                 curSum = sum;
            }
            if(maxSum < curSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}