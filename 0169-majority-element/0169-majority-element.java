class Solution {
    public int majorityElement(int[] nums) {
        int majorElement = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                majorElement = nums[i];
            }
            if(majorElement==nums[i]){
                count++;
            }
            else
                count--;
        }
        return majorElement;
    }
}