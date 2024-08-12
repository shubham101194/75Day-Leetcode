class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        
        st.push(asteroids[0]);
        
        for(int i=1;i<n;i++) {
            if(asteroids[i]>0)
                st.push(asteroids[i]);
            else {
                int val = asteroids[i];
                int res = 0;
                while(!st.isEmpty() && st.peek()>0 && val<0) {
                    int tmp = st.pop();
                    if(tmp>-val)
                        res = tmp;
                    else if(tmp<-val)
                        res = val;
                    else
                        res = 0;
                    
                    val = res;
                }
                
                if(val!=0)
                    st.push(val);
            }
        }
        
        int m = st.size();
        int[] result = new int[m];
        int idx = 1;
        while(!st.isEmpty()) {
            result[m-idx] = st.pop();
            idx++;
        }
        
        return result;
    }
}