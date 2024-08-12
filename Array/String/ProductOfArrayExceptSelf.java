class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] mult = new int[n];
        mult[0] = nums[0];
        
        for(int i=1;i<n;i++) {
            mult[i] = mult[i-1]*nums[i];
        }
        
        result[n-1] = mult[n-2];
        mult[n-1] = nums[n-1];
        
        for(int i=n-2;i>0;i--) {
            result[i] = mult[i-1]*mult[i+1];
            mult[i] = mult[i+1]*nums[i];
        }
        
        result[0] = mult[1];
        
        return result;
    }    
}