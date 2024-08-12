class Solution {

    public:
    int isvowel(char c)
    {
        if(c == 'a' || c == 'e' || c== 'i' || c=='o' || c=='u')
            return 1;
        return 0;
    }
    int maxVowels(string s, int k) {

        int ans= 0;
        int count = 0;

        for(int i = 0; i< k; i++)
        {
            count = count + isvowel(s[i]);
        }
        cout << count << '\n';
        ans = max(ans, count);

        int i =0;
        int j = k-1;

        while(j+1<s.length())
        {
            int a = isvowel(s[i]);
            int b = isvowel(s[j+1]);

            count = count + b -a;
            cout << "cnt=" << count << '\n';
            ans = max(ans, count);
            i++;
            j++;       
        }   

        return ans;     
    }
};