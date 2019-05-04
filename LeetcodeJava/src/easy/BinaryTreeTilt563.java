package easy;

public class BinaryTreeTilt563 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int tilt = 0;
        public int findTilt(TreeNode root) {
            findSum(root);
            return tilt;
        }
        private int findSum(TreeNode node){
            if(node==null){
                return 0;
            }
            int sa = findSum(node.left);
            int sb = findSum(node.right);
            tilt += Math.abs(sa-sb);
            return sa+sb+node.val;
        }
    }
}
