class Solution {
    public int totalPlants(int a, boolean left, boolean right) {
        if(left && right)
            a -=2;
        else if(left || right)
            a -= 1;
        
        if(a<=0)
            return 0;
        
        int j = a/2;
        
        return (a%2==0) ? j : j+1;
    }
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int result = 0;
        boolean leftOne = true;
        
        for(int i=0;i<flowerbed.length;i++) {
            if(flowerbed[i] == 0) {
                cnt++;
                if(i==0)
                    leftOne = false;
                
            }
            else {
                result += totalPlants(cnt,leftOne,true);
                leftOne = true;
                cnt = 0;
            }
        }
        
        if(cnt!=0)
            result += totalPlants(cnt,leftOne,false);
        
        return n<=result;
    }
}  