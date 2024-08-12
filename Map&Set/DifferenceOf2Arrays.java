class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int n : nums1)
            st1.add(n);
        for(int m : nums2)
            st2.add(m);
        
        List<Integer> tmp = new ArrayList<>();
        for(int s : st1) {
            if(!st2.contains(s))
                tmp.add(s);            
        }
        result.add(tmp);        
        tmp = new ArrayList<>();                
        
        for(int s : st2) {            
            if(!st1.contains(s))                
                tmp.add(s);            
        }
        
        result.add(new ArrayList<>(tmp));
        
        return result;
    }
}