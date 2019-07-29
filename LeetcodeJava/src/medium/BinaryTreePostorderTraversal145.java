package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            TreeNode p = root;
            while(!stack.isEmpty() || p!=null){
                while(p!=null){
                    stack.push(p);
                    p = p.left==null?p.right:p.left;
                }

                p = stack.pop();
                result.add(p.val);
                if((!stack.isEmpty()) && p == stack.peek().left){
                    p = stack.peek().right;
                }else{
                    p=null;
                }
            }
            return result;
        }
    }
}
