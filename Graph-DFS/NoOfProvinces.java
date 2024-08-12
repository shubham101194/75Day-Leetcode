class Solution {
    Set<Integer> st;
    public void dfs(int idx, List<Integer>[] arr) {
        st.add(idx);
        
        for(int a : arr[idx]) {
            if(!st.contains(a))
                dfs(a,arr);
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] arr = new ArrayList[n];
        
        for(int i=0;i<n;i++)
            arr[i] = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j)
                    continue;
                if(isConnected[i][j]==1) {
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        
        int result = 0;
        st = new HashSet<>();
        
        for(int i=0;i<n;i++) {
            if(!st.contains(i)) {
                st.add(i);
                dfs(i,arr);
                result++;
            }
        }
        
        return result;
    }
}