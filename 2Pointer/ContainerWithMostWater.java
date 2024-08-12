class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0,j=n-1;
        int result = Integer.MIN_VALUE;
        
        while(i<j) {
            int tmp = Math.min(height[i],height[j]);
            result = Math.max(result,tmp*(j-i));
            
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        
        return result;
    }
}