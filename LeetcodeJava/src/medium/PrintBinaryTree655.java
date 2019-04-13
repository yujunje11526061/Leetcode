package medium;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree655 {
    public static PrintBinaryTree655 instance = new PrintBinaryTree655();
    public Solution solution =  new Solution();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        d.left = e;
        System.out.println(instance.solution.printTree(a));
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
        private int maxL = 0;
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> printTree(TreeNode root) {

            if (root == null) {
                return new ArrayList<>();
            }
            dfs(root, 0);
            int row = maxL;
            int column = (int) Math.pow(2, maxL) - 1;
            for (int i = 0; i < row; i++) {
                ArrayList<String> al = new ArrayList<>();
                for (int j = 0; j < column; j++) {
                    al.add("");
                }
                result.add(al);
            }
            fill(root, 0, column - 1, 0);
            return result;

        }

        public void dfs(TreeNode node, int level) {
            if (node == null) {
                this.maxL = level > this.maxL ? level : this.maxL;
                return;
            }
            level++;
            dfs(node.left, level);
            dfs(node.right, level);
        }

        public void fill(TreeNode node, int l, int r, int level) {
            if (node == null) {
                return;
            }
            int location = (l + r) / 2;
            result.get(level).set(location, Integer.toString(node.val));
            level++;
            fill(node.left, l, location - 1, level);
            fill(node.right, location + 1, r, level);
        }
    }
}
