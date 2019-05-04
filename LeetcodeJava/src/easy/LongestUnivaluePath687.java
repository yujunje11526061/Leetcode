package easy;

public class LongestUnivaluePath687 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Info{
        TreeNode node;
        int len;
        public Info(TreeNode node, int len){
            this.node = node;
            this.len = len; // 包括该节点的最大单边长度
        }
    }

    class Solution {
        int maxL = 0;
        public int longestUnivaluePath(TreeNode root) {
            if(root==null){
                return 0;
            }
            find(root);
            return maxL-1;
        }

        private Info find(TreeNode node) {
            if(node ==null){
                return new Info(null, 0);
            }
            Info infoLeft = find(node.left);
            Info infoRight = find(node.right);
            int len = 1;
            int ll=0,lr = 0; // 左右两边可利用的长度
            if(infoLeft.node!=null && infoLeft.node.val==node.val){
                ll = infoLeft.len;
            }
            if(infoRight.node!=null && infoRight.node.val==node.val){
                lr = infoRight.len;
            }
            len += Math.max(ll,lr);
            maxL = Math.max(maxL, ll+lr+1);
            return new Info(node, len);
        }
    }
}
