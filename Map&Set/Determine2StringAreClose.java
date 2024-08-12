class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Map<Integer,Integer> mp = new HashMap<>();
        Set<Character> st = new HashSet<>();
        if(n!=m)
            return false;
        
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        int cnt=1;
        st.add(ch1[0]);
        for(int i=1;i<n;i++) {
            st.add(ch1[i]);
            if(ch1[i]==ch1[i-1])
                cnt++;
            else {
                mp.put(cnt,mp.getOrDefault(cnt,0)+1);
                cnt=1;
            }
        }
        mp.put(cnt,mp.getOrDefault(cnt,0)+1);
        
        cnt=1;
        if(!st.contains(ch2[0]))
            return false;
        for(int i=1;i<m;i++) {
            if(!st.contains(ch2[i]))
                return false;
            if(ch2[i]==ch2[i-1])
                cnt++;
            else {
                if(!mp.containsKey(cnt))
                    return false;
                mp.put(cnt,mp.get(cnt)-1);
                if(mp.get(cnt)==0)
                    mp.remove(cnt);
                
                cnt=1;
            }
        }
        if(!mp.containsKey(cnt))
            return false;
        mp.put(cnt,mp.get(cnt)-1);
        if(mp.get(cnt)==0)
            mp.remove(cnt);
        
        return mp.isEmpty();
        
    }
}