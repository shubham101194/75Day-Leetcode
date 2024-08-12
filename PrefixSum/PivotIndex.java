class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        
        prefix[0] = nums[0];
        
        for(int i=1;i<n;i++)
            prefix[i] = prefix[i-1]+nums[i];
        
        int sum = prefix[n-1];
        
        if(sum-prefix[0]==0)
            return 0;
        
        for(int i=0;i<n-1;i++) {
            if(prefix[i]==sum-prefix[i+1]) {
                System.out.println(prefix[i]);
                System.out.println(sum-prefix[i+1]);
                return i+1;
            }
        }
        
        if(prefix[n-2]==0)
            return n-1;
        
        return -1;
    }
}