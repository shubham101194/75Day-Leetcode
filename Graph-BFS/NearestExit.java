class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int idx = 0;
        
        q.add(new Pair(entrance[0],entrance[1]));
        visited[entrance[0]][entrance[1]] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();            
            idx++;
            
            for(int i=0;i<size;i++) {
                Pair<Integer,Integer> p = q.poll();
                int r = p.getKey();
                int c = p.getValue();
                
                if(r+1<n && maze[r+1][c]!='+' && !visited[r+1][c]) {
                    if(r+1==n-1 || c==0 || c==m-1)
                        return idx;
                    q.add(new Pair(r+1,c));
                    visited[r+1][c] = true;
                }
                if(r-1>=0 && maze[r-1][c]!='+' && !visited[r-1][c]) {
                    if(r-1==0 || c==0 || c==m-1)
                        return idx;
                    q.add(new Pair(r-1,c));
                    visited[r-1][c] = true;
                }
                if(c+1<m && maze[r][c+1]!='+' && !visited[r][c+1]) {
                    if(c+1==m-1 || r==0 || r==n-1)
                        return idx;
                    q.add(new Pair(r,c+1));
                    visited[r][c+1] = true;
                }
                if(c-1>=0 && maze[r][c-1]!='+' && !visited[r][c-1]) {
                    if(c-1==0 || r==0 || r==n-1)
                        return idx;
                    q.add(new Pair(r,c-1));
                    visited[r][c-1] = true;
                }
            }
        }
        
        return -1;
    }
}