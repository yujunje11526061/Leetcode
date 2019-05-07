package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> list = new LinkedList<>();
            if(root==null){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int len = 1;
            long tot = 0;
            long cnt = 0;
            while(!queue.isEmpty()){
                TreeNode p = queue.poll();
                if(p.left!=null){
                    queue.offer(p.left);
                }
                if(p.right!=null){
                    queue.offer(p.right);
                }
                tot += p.val;
                cnt++;
                len--;
                if(len==0){
                    double result = tot*1.0/cnt;
                    list.add(result);
                    tot=0;
                    cnt=0;
                    len=queue.size();
                }
            }
            return list;
        }
    }
}
