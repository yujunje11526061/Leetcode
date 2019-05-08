package medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n == 0)
                return new ArrayList<>();
            return generateTrees(1,n);
        }
        public List<TreeNode> generateTrees(int start,int end) {
            List<TreeNode> res = new ArrayList<>();
            if(start > end){
                res.add(null);
                return res;
            }
            for(int i = start;i <= end;i++){
                List<TreeNode> subLeftTree = generateTrees(start,i-1);
                List<TreeNode> subRightTree = generateTrees(i+1,end);
                for(TreeNode left : subLeftTree){
                    for(TreeNode right : subRightTree){
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            }
            return res;
        }
    }
}
