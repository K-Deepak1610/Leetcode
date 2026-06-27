class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = -1;
        while(left < right){
            int width = right - left;
            int length = Math.min(height[left],height[right]);
            result = Math.max(result,width*length);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}