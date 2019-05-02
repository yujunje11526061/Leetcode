package easy;

import java.util.Stack;

public class RangeSumofBST938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            int cnt = 0;
            while(p!=null || !stack.isEmpty()){
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if(p.val>=L){
                    if(p.val<=R){
                        cnt += p.val;
                    }else{
                        return cnt;
                    }
                }
                p=p.right;
            }
            return cnt;
        }
    }
}
