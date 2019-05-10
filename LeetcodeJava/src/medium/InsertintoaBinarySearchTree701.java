package medium;

public class InsertintoaBinarySearchTree701 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null){
                return new TreeNode(val);
            }
            if(root.val<val){
                root.right = insertIntoBST(root.right,val);
            }else{
                root.left = insertIntoBST(root.left,val);
            }
            return root;
        }
    }
}
