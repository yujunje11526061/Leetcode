package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlipBinaryTreeToMatchPreorderTraversal971 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            List<Integer> list = new ArrayList<>();
            List<Integer> listWhenNoCan = new ArrayList<>();
            listWhenNoCan.add(-1);
            if(root==null&&voyage.length>0){
                return listWhenNoCan;
            }
            int i=0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p =root;
            while(!stack.empty() || p !=null){
                while(p!=null){
                    if(i<voyage.length && p.val!=voyage[i]){
                        return listWhenNoCan;
                    }else{
                        i++;
                        if((p.left==null) || (p.left!=null && i<voyage.length && p.left.val==voyage[i])){
                            stack.push(p.right);
                            p= p.left;
                        }else{
                            list.add(p.val);
                            TreeNode temp = p.left;
                            p.left = p.right;
                            p.right = temp;
                            stack.push(p.right);
                            p= p.left;
                        }
                    }
                }
                p = stack.pop();
            }
            return list;
        }
    }
}
