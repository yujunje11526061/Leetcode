package easy;

public class PathSum112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private boolean flag = false;
        private int sum;
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            this.sum = sum;
            dfs(root,0);
            return flag;
        }

        private void dfs(TreeNode p, int temp) {
            if(flag){return;}

            temp += p.val;
            if (p.left == null && p.right == null && temp==sum) {
                flag = true;
                return;
            }
            if (p.left != null) {
                dfs(p.left, temp);
            }
            if (p.right != null) {
                dfs(p.right, temp);
            }
        }
    }
}
