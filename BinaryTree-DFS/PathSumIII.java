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
    Integer result = 0;
    
    public void pathSumUtil(TreeNode root, int targetSum, int curr, HashMap<Integer,Integer> mp) {
        if(root==null)
            return;
        
        curr += root.val;
        result += mp.getOrDefault((curr-targetSum),0);
        
        mp.put(curr, mp.getOrDefault(curr,0)+1);
        pathSumUtil(root.left, targetSum, curr, mp);
        pathSumUtil(root.right, targetSum, curr, mp);
        mp.put(curr, mp.get(curr)-1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        pathSumUtil(root, targetSum, 0, mp);
        
        return result;
    }
}