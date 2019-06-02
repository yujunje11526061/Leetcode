package medium;

import java.util.*;

public class SmallestSubtreewithalltheDeepestNodes865 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<List<TreeNode>> lists = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        int maxDepth = 0;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            find(root);
            if (lists.size() == 2) {
                return lists.get(0).get(lists.get(0).size() - 1);
            } else {
                TreeNode pp = null, p = lists.get(0).get(0);
                int x = 0;
                boolean flag= false;
                while (true) {
                    for (List<TreeNode> list : lists) {
                        if (list.get(x) != p) {
                            flag=true;
                            break;
                        }

                    }
                    if(flag){break;}
                    pp = p;
                    x++;
                    p = lists.get(0).get(x);
                }
                return pp;
            }
        }

        private void find(TreeNode p) {
            if (p == null) {
                if (temp.size() > maxDepth) {
                    maxDepth = temp.size();
                    lists.clear();
                    List<TreeNode> t = new ArrayList(temp);
                    lists.add(t);
                } else if (temp.size() == maxDepth) {
                    List<TreeNode> t = new ArrayList(temp);
                    lists.add(t);
                }
                return;
            }
            temp.add(p);
            find(p.left);
            find(p.right);
            temp.remove(temp.size() - 1);
        }
    }
}
