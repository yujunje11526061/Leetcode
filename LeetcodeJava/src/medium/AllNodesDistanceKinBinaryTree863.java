package medium;

import hard.SerializeandDeserializeBinaryTree297;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKinBinaryTree863 {
    public static AllNodesDistanceKinBinaryTree863 instance = new AllNodesDistanceKinBinaryTree863();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        a.left = b;
        b.left = c;
        b.right = d;
        d.left = e;
        System.out.println(instance.solution.distanceK(a,d,1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private List<Integer> result = new ArrayList<>();
        private List<TreeNode> path = new ArrayList<>();
        private List<Integer> leftOrRight = new ArrayList<>();
        private boolean flag = false; 
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            findPath(root, target);
            if(!flag){
                return result;
            }
            for(int i=0;i<path.size()-1;i++){
                int f = path.get(i).left==path.get(i+1)?1:0;
                leftOrRight.add(f);
            }
            findNode(target, K);
            for(int i=0;i<leftOrRight.size();i++){
                int distance = leftOrRight.size()-i;
                if(distance<K){
                    if(leftOrRight.get(i)==1){
                        findNode(path.get(i).right, K-distance-1);
                    }else{
                        findNode(path.get(i).left, K-distance-1);
                    }
                }else if(distance==K){
                    result.add(path.get(i).val);
                }else{
                    continue;
                }
            }
            return result;
            
        }
        
        private void findPath(TreeNode p, TreeNode target){
            if(p==null){
                return;
            }
            path.add(p);
            if(p == target){
                flag=true;
                return;
            }
            findPath(p.left, target);
            if(flag){
                return;
            }
            findPath(p.right, target);
            if(flag){
                return;
            }
            path.remove(path.size()-1);
            return;
        }
        
        private void findNode(TreeNode p, int count){
            if(p==null){
                return;
            }
            if(count==0){
                result.add(p.val);
            }else{
                findNode(p.left,count-1);
                findNode(p.right,count-1);
            }
        }
    }
}
