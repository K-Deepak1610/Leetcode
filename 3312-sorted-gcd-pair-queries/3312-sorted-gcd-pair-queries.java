class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
       int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        
        long[] gcdCnt = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            long mulCnt = 0;
            for (int j = i; j <= max; j += i) {
                mulCnt += cnt[j];
            }
            
            long pairs = mulCnt * (mulCnt - 1) / 2;
            for (int j = 2 * i; j <= max; j += i) {
                pairs -= gcdCnt[j];
            }
            gcdCnt[i] = pairs;
        }
        
        for (int i = 1; i <= max; i++) {
            gcdCnt[i] += gcdCnt[i - 1];
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            int l = 1, r = max;
            
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (gcdCnt[mid] > q) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = l;
        }
        
        return ans; 
    }
}