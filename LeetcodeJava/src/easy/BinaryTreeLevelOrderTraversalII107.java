package easy;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }

            Stack<List<Integer>> stack= new Stack<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int cnt = 1;
            LinkedList<List<Integer>> result = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode p = queue.poll();
                temp.add(p.val);
                cnt--;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if(cnt==0){
                    cnt = queue.size();
                    result.addFirst(temp);
                    temp = new ArrayList<>();
                }
            }
            return result;
        }
    }
}
