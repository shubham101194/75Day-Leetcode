class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double result = 0;
        int sum = 0;
        
        if(k>n)
            return result;
        for(int i=0;i<k;i++)
            sum += nums[i];
        
        result = sum;
        
        for(int i=1;i+k-1<n;i++) {
            sum = sum-nums[i-1]+nums[i+k-1];            
            result = Math.max(result,sum);            
        }
        
        return result/k;
    }
}