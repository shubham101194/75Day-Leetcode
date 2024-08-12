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
    List<Integer> tree1 = new ArrayList<>();
    List<Integer> tree2 = new ArrayList<>();
    
    public void util(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            list.add(root.val);           
        
        util(root.left,list);
        util(root.right,list);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        util(root1,tree1);
        util(root2,tree2);
        
        System.out.println(tree1);
        System.out.println(tree2);
        int n = tree1.size();
        int m = tree2.size();
        if(n==m) {
            System.out.println("Shub");
            for(int i=0;i<n;i++) {
                int a = tree1.get(i);
                int br = tree2.get(i);
                if(tree1.get(i) != tree2.get(i)) {
                    System.out.println("i: " + i + ", tree1: " + tree1.get(i) + ", tree2: " + tree2.get(i));
                    return false;
                }
            }
            return true;
        }
        
        return false;
        
        //return tree1.equals(tree2);
    }
}