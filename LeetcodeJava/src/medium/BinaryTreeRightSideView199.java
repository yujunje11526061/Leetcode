package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root==null){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int len = 1;  // 用一个队列计数器就可以得知某一层便利店的结束，不需要两个队列来回倒腾。
            while (queue.size() > 0) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                len--;
                if (len == 0) {
                    list.add(p.val);
                    len = queue.size();
                }

            }
            return list;
        }
    }
}
