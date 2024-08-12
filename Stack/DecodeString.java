class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            
            if(c!=']')
                st.push(Character.toString(c));
            else {
                StringBuilder sb = new StringBuilder();
                StringBuilder sum = new StringBuilder();
                
                while(!st.isEmpty() && st.peek().charAt(0) != '[')
                    sb.insert(0,st.pop());
                st.pop(); // removing '['
                
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))
                    sum.insert(0,st.pop());
                
                int k = Integer.parseInt(sum.toString());
                String subStr = sb.toString();
                
                while(k-- > 0)
                    st.push(subStr);
                
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) 
            res.insert(0, st.pop());    
        
        return res.toString();
    }
}