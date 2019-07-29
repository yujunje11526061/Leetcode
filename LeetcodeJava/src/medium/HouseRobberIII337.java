package medium;

import java.util.Arrays;

public class HouseRobberIII337 {

    public static HouseRobberIII337 instance = new HouseRobberIII337();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.right = d;
        c.right = e;
        System.out.println(instance.solution.rob(a));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            int[] result = find(root);
            return Math.max(result[0], result[1]);
        }

        private int[] find(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }

            int[] left = find(node.left);
            int[] right = find(node.right);

//            int[] now = {Math.max(Math.max(Math.max(left[1] + right[1], left[0] + right[1]), left[1] + right[0]),left[0]+right[0]), left[0] + right[0] + node.val};
//            不带当前根时，最理想的情况是左右分别取最大，或者上述烦琐写法，即left[0]+right[0]也可以不带当前根
            int[] now = {Math.max(left[0], left[1]) + Math.max(right[0], right[1]), left[0] + right[0] + node.val};

            return now;
        }
    }
}
