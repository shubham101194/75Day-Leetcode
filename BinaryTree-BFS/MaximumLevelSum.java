/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair(root,1));
        Map<Integer,Integer> mp = new HashMap<>();
        int maxLevel = 0;
        
        while(!q.isEmpty()) {
            Pair<TreeNode,Integer> p = q.poll();
            int level = p.getValue();
            TreeNode tmp = p.getKey();
            int valu = tmp.val;
            
            mp.put(level,mp.getOrDefault(level,0)+valu);
            if(tmp.left!=null)
                q.add(new Pair(tmp.left,level+1));
            if(tmp.right!=null)
                q.add(new Pair(tmp.right,level+1));
            
            maxLevel = level;
        }
                
        int result = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i=1;i<=maxLevel;i++) {
            System.out.println("val: " + mp.get(i));
            if(mp.get(i)>result) {
                result = mp.get(i);
                index = i;
            }
        }
        
        return index;
        
    }
}