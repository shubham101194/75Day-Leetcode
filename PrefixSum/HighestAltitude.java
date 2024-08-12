class Solution {
    public int largestAltitude(int[] gain) {
        int result = 0;
        int sum = 0;
        
        for(int n : gain) {
            sum += n;
            result = Math.max(result,sum);
        }
        
        return result;
    }
}