class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    private static int binarySearch(int [] nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
         int mid = low + (high-low)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]<target){
            return binarySearch(nums,mid+1,high,target);
        }
        else{
            return binarySearch(nums,low,mid-1,target);
        }
    }
}