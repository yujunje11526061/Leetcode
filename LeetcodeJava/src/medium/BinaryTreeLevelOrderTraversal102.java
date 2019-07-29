package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> temp = new ArrayList<>();
            int thisLevel = 1;
            int nextLevel = 0;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                temp.add(node.val);
                thisLevel--;
                if(node.left!=null){
                    queue.offer(node.left);
                    nextLevel++;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    nextLevel++;
                }

                if(thisLevel==0){
                    thisLevel=nextLevel;
                    nextLevel=0;
                    result.add(temp);
                    temp = new ArrayList<>();
                }
            }

            return result;
        }
    }
}
