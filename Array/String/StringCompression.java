class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        char c = chars[0];
        int cnt = 1;
        int idx = 0;
        
        for(int i=1;i<n;i++) {
            if(chars[i] != c) {
                chars[idx++] = c;
                if(cnt!=1) {
                    for(char ch : Integer.toString(cnt).toCharArray()) {
                        chars[idx++] = ch;
                    }                    
                }
                c = chars[i];
                cnt = 1;
            }
            else
                cnt++;
        }
        
        chars[idx++] = c;
        if(cnt!=1) {
            for(char ch : Integer.toString(cnt).toCharArray()) {
                chars[idx++] = ch;
            }                    
        }
        
        return idx;
    }
}