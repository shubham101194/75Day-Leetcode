class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        int n = arr.length;
        
        for(int i=0;i<n;i++)
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        
        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
            st.add(entry.getValue());
        
        if(st.size()==mp.size())
            return true;
        return false;
    }
}