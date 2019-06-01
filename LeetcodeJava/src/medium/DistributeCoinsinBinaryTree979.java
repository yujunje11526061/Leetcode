package medium;

import java.util.Stack;

public class DistributeCoinsinBinaryTree979 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Info{
        int innerMove;
        int cnt;
        int amount;

        public Info(int innerMove, int cnt, int amount) {
            this.innerMove = innerMove;
            this.cnt = cnt;
            this.amount = amount;
        }
    }

    class Solution {
        int avg;
        public int distributeCoins(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            int tot = 0;
            int cnt = 0;
            while(p!=null || !stack.isEmpty()){
                while(p!=null){
                    stack.push(p);
                    p = p.left==null?p.right:p.left;
                }
                p = stack.pop();
                cnt++;
                tot += p.val;
                if(!stack.isEmpty() && stack.peek().left==p){
                    p = stack.peek().right;
                }else{
                    p=null;
                }
            }
            this.avg = tot/cnt;
            Info info = calculate(root);
            return info.innerMove;
        }

        private Info calculate(TreeNode p) {
            if(p==null){
                return new Info(0,0,0);
            }
            Info infoLeft = calculate(p.left);
            Info infoRight = calculate(p.right);
            int cnt = infoLeft.cnt+infoRight.cnt+1;
            int amount = infoLeft.amount+infoRight.amount+p.val;
            int innerMove = Math.abs(infoLeft.amount-infoLeft.cnt*avg)+ Math.abs(infoRight.amount-infoRight.cnt*avg)
                            + infoLeft.innerMove+infoRight.innerMove;
            return new Info(innerMove,cnt,amount);
        }
    }
}
