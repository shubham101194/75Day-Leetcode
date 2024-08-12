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
    int result = 0;
    
    public void util(TreeNode root, int max) {
        if(root==null)
            return;
        if(root.val>=max)
            result++;
        
        util(root.left,Math.max(max,root.val));
        util(root.right,Math.max(max,root.val));
    }
    
    public int goodNodes(TreeNode root) {
        util(root,root.val);
        
        return result;
    }
}