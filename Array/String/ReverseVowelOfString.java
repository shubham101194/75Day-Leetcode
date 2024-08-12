class Solution {
    public boolean isVowel(Character c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return true;
        return false;
    }
    
    public String reverseVowels(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        int j = n-1;
        
        while(i<j) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);
            
            if(!isVowel(c1))
                i++;
            if(!isVowel(c2))
                j--;
            if(isVowel(c1) && isVowel(c2)) {
                char tmp = c1;
                str.setCharAt(i,c2);
                str.setCharAt(j,tmp);
                i++;
                j--;
            }
        }
        
        return str.toString();
    }
}