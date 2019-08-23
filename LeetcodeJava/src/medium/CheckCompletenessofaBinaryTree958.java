package medium;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree958 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if(root==null){
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode p = queue.poll();
                if(p==null){
                    break;
                }
                queue.offer(p.left);
                queue.offer(p.right);
            }
            while(!queue.isEmpty()){
                if(queue.poll()!=null){
                    return false;
                }
            }
            return true;
        }
    }
}
