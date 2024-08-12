class Solution {
    double[] result;
    
    public void dfs(String u, String v, Map<String,List<Pair<String,Double>>> mp, Double val, int idx, Set<String> st) {
        if(result[idx] != 0 || st.contains(u))
            return;
        
        st.add(u);
        //System.out.println("u: "+u+", v: "+v+", mp[u]: "+mp.get(u)+", val: "+val+", idx: "+idx);
        List<Pair<String,Double>> lt = mp.get(u);
        
        for(Pair<String,Double> p : lt) {
            String p1 = p.getKey();
            Double p2 = p.getValue();
            
            if(p1.equals(v)) {
                result[idx] = val*p2;                
                return;
            }
            
            dfs(p1,v,mp,val*p2,idx,st);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> mp = new HashMap<>();
        int n = values.length;
        int m = queries.size();
        result = new double[m];
        
        for(int i=0;i<n;i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            
            if(!mp.containsKey(u))
                mp.put(u,new ArrayList<>());
            mp.get(u).add(new Pair(v,values[i]));
            
            double rec = 1/values[i];
            
            if(!mp.containsKey(v))
                mp.put(v,new ArrayList<>());
            mp.get(v).add(new Pair(u,rec));
        }                
        
        for(int i=0;i<m;i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            
            if(!mp.containsKey(u) || !mp.containsKey(v)) {
                result[i] = -1;
                continue;
            }                
            
            dfs(u,v,mp,(double) 1,i, new HashSet<>());
            if(result[i] == 0)
                result[i] = -1;
        }
        
        return result;
    }
}