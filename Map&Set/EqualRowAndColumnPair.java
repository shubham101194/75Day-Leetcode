class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;        
        Map<List<Integer>,Integer> mp = new HashMap<>();
        int result = 0;
        
        for(int i=0;i<n;i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<n;j++) {
                tmp.add(grid[i][j]);
            }
            List<Integer> fin = new ArrayList<>(tmp);
            mp.put(fin,mp.getOrDefault(fin,0)+1);   
        }            
        
        //System.out.println(mp);
        
        for(int i=0;i<n;i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<n;j++) {
                tmp.add(grid[j][i]);
            }
            //System.out.println(tmp);
            if(mp.containsKey(new ArrayList<>(tmp)))
                result+=mp.get(new ArrayList<>(tmp));
        }
        
        return result;
    }
}