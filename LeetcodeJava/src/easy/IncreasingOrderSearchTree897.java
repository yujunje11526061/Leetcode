package easy;

import java.util.ArrayList;

public class IncreasingOrderSearchTree897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            ArrayList<TreeNode> stack = new ArrayList<>();
            TreeNode p = root;
            TreeNode newRoot = null, newp = null, pp = null;
            while (!stack.isEmpty() || p != null) {
                while (p != null) {
                    stack.add(p);
                    p = p.left;
                }
                pp = stack.remove(stack.size() - 1);
                p = pp.right;
                if (newRoot == null) {
                    newRoot = pp;
                } else {
                    newp.right = pp;
                }
                newp = pp;
                newp.left = null;
                newp.right = null;
            }
            return newRoot;
        }
    }
}
