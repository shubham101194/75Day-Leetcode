class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int[] visited = new int[n];
        
        for(int i=0;i<n;i++) {
            if(senate.charAt(i)=='R')
                q1.add(i);
            else
                q2.add(i);
        }
        
        //System.out.println(q1);
        //System.out.println(q2);
        
        int i=0;
        
        while(true) {
            if(visited[i]==0) {
                if(senate.charAt(i)=='R') {
                    int tmp = q1.poll();
                    if(q2.isEmpty())
                        return "Radiant";
                    visited[q2.poll()] = 1;   
                    q1.add(tmp);
                }
                else {
                    int tmp = q2.poll();
                    if(q1.isEmpty())
                        return "Dire";
                    visited[q1.poll()] = 1;
                    q2.add(tmp);
                }
            }
            
            i = (i+1)%n;
        }
    }
}