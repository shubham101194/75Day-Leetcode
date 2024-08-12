class Solution {
    public String reverseWords(String s) {
        String[] arrStr = s.split(" ");
        int n = arrStr.length;
        StringBuilder result = new StringBuilder();
        
        for(int i=n-1;i>=0;i--) {
            if(arrStr[i] != "") {
                result.append(arrStr[i]);
                result.append(" ");
            }
                
        }            
        
        return result.substring(0,result.length()-1).toString();
    }
}