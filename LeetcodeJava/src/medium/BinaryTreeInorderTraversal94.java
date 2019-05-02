package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            TreeNode p = root;
            while(p!=null || !stack.isEmpty()){
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
            return list;
        }
    }
}
