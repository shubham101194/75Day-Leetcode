class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int i=0,j=n-1,result=0;
        Arrays.sort(nums);
        
        while(i<j) {
            if(nums[i]+nums[j]<k)
                i++;
            else if(nums[i]+nums[j]>k)
                j--;
            else {
                result++;
                i++;
                j--;
            }
        }
        
        return result;
    }
}