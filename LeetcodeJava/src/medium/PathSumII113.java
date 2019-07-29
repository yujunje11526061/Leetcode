package medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> temp = new ArrayList<>();
        private int sum;
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return result;
            }
            this.sum = sum;
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode p, int val) {
            val += p.val;
            temp.add(p.val);
            if(p.left==null && p.right == null && val==sum){
                result.add(new ArrayList<>(temp));
            }
            if(p.left!=null){
                dfs(p.left, val);
            }
            if (p.right != null) {
                dfs(p.right,val);
            }

            temp.remove(temp.size()-1);
        }
    }
}
