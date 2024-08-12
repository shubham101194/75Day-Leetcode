class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<3)
            return false;
        int[] count = new int[n];
        count[0] = nums[0];
        count[n-1] = nums[n-1];
        
        for(int i=1;i<n-1;i++) {
            count[i] = Math.min(nums[i],count[i-1]);
        }
        
        int i;
        for(i=n-2;i>0;i--) {
            if(count[i-1]<nums[i] && count[i+1]>nums[i])
                break;
            count[i] = Math.max(count[i+1],nums[i]);
        }
        
        return (i!=0);
    }
}