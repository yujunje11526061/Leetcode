package medium;

public class SumRoottoLeafNumbers129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private int result = 0;
        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root,0);
            return result;
        }

        private void dfs(TreeNode node, int val) {
            val = val*10 + node.val;
            if(node.left==null && node.right==null){
                result += val;
                return;
            }
            if(node.left!=null) {
                dfs(node.left, val);
            }
            if(node.right!=null) {
                dfs(node.right, val);
            }
        }
    }
}
