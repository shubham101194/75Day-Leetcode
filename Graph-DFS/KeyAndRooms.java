class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> st = new HashSet<>();
        
        q.add(0);
        st.add(0);
        
        while(!q.isEmpty()) {
            int idx = q.poll();
            
            for(int a : rooms.get(idx)) {
                if(!st.contains(a)) {
                    st.add(a);
                    q.add(a);
                }                    
            }                
        }
        
        return st.size()==n;
    }
}