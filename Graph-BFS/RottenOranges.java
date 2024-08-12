class Solution {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        int cnt = 0;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==2)
                    q.add(new Pair(i,j));
                else if(grid[i][j]==1)
                    cnt++;
            }
        }
        
        if(cnt==0)
            return result;
        
        while(!q.isEmpty()) {
            int size = q.size();
            result++;
            
            for(int i=0;i<size;i++) {
                Pair<Integer,Integer> p = q.poll();
                int r = p.getKey();
                int c = p.getValue();
                
                for(int j=0;j<4;j++) {
                    int x = r+direction[j][0];
                    int y = c+direction[j][1];
                    
                    if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1) {
                        cnt--;
                        q.add(new Pair(x,y));
                        grid[x][y] = 2;
                    }
                }
            }
        }
        
        if(cnt!=0)
            return -1;
        return result-1;
    }
}