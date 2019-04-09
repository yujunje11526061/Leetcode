package medium;

import java.util.ArrayList;

public class ValidateBinarySearchTree98 {
    public Solution solution = new Solution();
    public static ValidateBinarySearchTree98 instance = new ValidateBinarySearchTree98();
    public TreeNode root = new TreeNode(2);
    public TreeNode a = new TreeNode(5);
    public TreeNode b = new TreeNode(15);
    public TreeNode c = new TreeNode(6);
    public TreeNode d = new TreeNode(20);
    public static void main(String[] args) {
        instance.solution.isValidBST(instance.root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }

            TreeNode p = root,prev=null;
            ArrayList<TreeNode> stack = new ArrayList<>();
            while(!stack.isEmpty() || p != null){
                while(p!=null){
                    stack.add(p);
                    p = p.left;
                }
                p = stack.remove(stack.size()-1);
                if (prev==null){
                    prev = p;
                }
                else if (p.val<=prev.val){
                    return false;
                }
                else{
                    prev = p;
                }
                p = p.right;
            }
            return true;
        }
    }

}
