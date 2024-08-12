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
    
    public void util(TreeNode root, int val) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            result = Math.max(result,1+val);
        }
        
        util(root.left,val+1);
        util(root.right,val+1);
    }
        
    public int maxDepth(TreeNode root) {
        util(root,0);
        
        return result;
    }
}