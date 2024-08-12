class Solution {
    public int minReorder(int n, int[][] connections) {        
        List<Pair<Integer,Integer>>[] arr = new ArrayList[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        
        for(int i=0;i<n;i++)
            arr[i] = new ArrayList<>();
        
        for(int[] c : connections) {
            int u = c[0];
            int v = c[1];
            arr[u].add(new Pair(v,1));
            arr[v].add(new Pair(u,0));
        }
        
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            
            for(Pair<Integer,Integer> p : arr[tmp]) {
                int neighbor = p.getKey();
                int val = p.getValue();
                
                if(!visited[neighbor]) {
                    result += val;
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }        
        
        return result;
    }
}