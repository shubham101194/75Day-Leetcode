class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        List<Boolean> result = new ArrayList<>();
        
        for(int c : candies)
            maxCandies = Math.max(maxCandies,c);
        
        for(int c : candies) {
            if(c + extraCandies >= maxCandies)
                result.add(true);                
            else
                result.add(false);
        }
        
        return result;
    }
}