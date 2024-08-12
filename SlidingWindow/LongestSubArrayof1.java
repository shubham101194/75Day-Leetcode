class Solution {
    public int longestSubarray(int[] nums) {
        int end = 0;
        int start = 0;
        int n = nums.length;
        int zeros = 0;
        int result = 0;
        
        while(end<n) {
            zeros += (nums[end]==0 ? 1:0);
            end++;
            
            while(zeros>1) {
                zeros -= (nums[start]==0 ? 1:0);
                start++;
            }
            
            result = Math.max(result,end-start);
        }
        
        return result-1;
    }
}