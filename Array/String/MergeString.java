class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        String result = "";
        int i = 0;

        while(i<n && i<m) {
            result += Character.toString(word1.charAt(i));
            result += Character.toString(word2.charAt(i));
            i++;
        }

        if(i<n) {
            result += word1.substring(i,n);
        }
        else if(i<m) {
            result += word2.substring(i,m);
        }

        return result;
    }
}