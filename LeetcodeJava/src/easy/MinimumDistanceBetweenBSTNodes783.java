package easy;

import javax.swing.text.MaskFormatter;
import java.util.LinkedList;
import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes783 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int minDiffInBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            int min = 0x7fffffff;
            TreeNode pre = null,p=root;
            while(p!=null || !stack.isEmpty()){
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
                TreeNode node = stack.pop();
                if(pre!=null){
                    min = min<node.val-pre.val?min:node.val-pre.val;
                }
                pre = node;
                p = node.right;
            }

            return min;

        }
    }
}
