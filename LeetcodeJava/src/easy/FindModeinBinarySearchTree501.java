package easy;

import java.util.ArrayList;

public class FindModeinBinarySearchTree501 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private ArrayList<Integer> arrayList = new ArrayList<>();
        private int cnt = 0;
        private  int maxCnt = 0;
        private TreeNode pre = null;
        public int[] findMode(TreeNode root) {
            if(root==null){
                return new int[0];
            }
            inOrderTraversal(root);
            if(cnt>maxCnt){
                arrayList.clear();
                arrayList.add(pre.val);
            }else if(cnt==maxCnt){
                arrayList.add(pre.val);
            }
            int[] result = new int[arrayList.size()];
            for(int i=0;i<result.length;i++){
                result[i] = arrayList.get(i);
            }
            return result;
        }

        private void inOrderTraversal(TreeNode node){
            if(node==null){
                return;
            }
            inOrderTraversal(node.left);
            if(pre==null || pre.val==node.val){
                cnt++;
            }else{
                if(cnt>maxCnt){
                    arrayList.clear();
                    maxCnt = cnt;
                    arrayList.add(pre.val);
                }else if(cnt==maxCnt){
                    arrayList.add(pre.val);
                }
                cnt = 1;
            }
            pre = node;
            inOrderTraversal(node.right);
        }
    }
}


