package hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump975 {
    public static OddEvenJump975 instance = new OddEvenJump975();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {10,13,12,14,15};
        int[] B = {2,3,1,1,4};
        System.out.println(instance.solution.oddEvenJumps(A));
    }

    class Solution {
        // 思路为DP+BST，我手写搜索树，没加平衡功能，Java自带的TreeMap为红黑树，自带平衡功能
        // 且Map.Entry hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i])，巧用自带API，可以少写不少代码。
        // 不过按这种直接调用API的写法，应该会导致三次搜索。手写可以根据需要边搜边更新。

//        public int oddEvenJumps(int[] A) {
//            int n  = A.length, res = 1;
//            boolean[] higher = new boolean[n], lower = new boolean[n];
//            higher[n - 1] = lower[n - 1] = true;
//            TreeMap<Integer, Integer> map = new TreeMap<>();
//            map.put(A[n - 1], n - 1);
//            for (int i = n - 2; i >= 0; --i) {
//                Map.Entry hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
//                if (hi != null) higher[i] = lower[(int)hi.getValue()];
//                if (lo != null) lower[i] = higher[(int)lo.getValue()];
//                if (higher[i]) res++;
//                map.put(A[i], i);
//            }
//            return res;
//        }

        class Node{
            int val;
            Node left = null;
            Node right = null;
            int index;
            public Node(int val, int index){
                this.val = val;
                this.index = index;
            }
        }
        int[] forOdd;
        int[] forEven;
        int[] isGood;
        public int oddEvenJumps(int[] A) {
            forOdd = new int[A.length];
            forEven = new int[A.length];
            isGood = new int[A.length]; // 0:奇偶跳都不好，1:奇数跳好，2:偶数跳好，3:奇偶都好
            // O(n^2)超时
//            for(int i=0;i<A.length;i++){
//                int minLarger = 0x7fffffff;
//                int maxSmaller = 0;
//                for(int j=i+1;j<A.length;j++){
//                    if(A[j]==A[i]){
//                        minLarger = j;
//                        maxSmaller = j;
//                        forOdd[i] = j;
//                        forEven[i] = j;
//                        break;
//                    }else if(A[j]>A[i]){
//                        if(A[j]<minLarger){
//                            minLarger = A[j];
//                            forOdd[i] = j;
//                        }
//                    }else{
//                        if (A[j]>maxSmaller){
//                            maxSmaller = A[j];
//                            forEven[i] = j;
//                        }
//                    }
//                }
//            }
            Node root = null;
            for(int i=A.length-1;i>=0;i--){
                Node node = new Node(A[i], i);
                if(root == null){
                    root = node;
                    continue;
                }
                Node p=root, pp=null;
                while(p!=null){
                    if(node.val<p.val){
                        forOdd[i] = p.index;
                        pp=p;
                        p = p.left;
                    }else if(node.val>p.val){
                        forEven[i] = p.index;
                        pp=p;
                        p = p.right;
                    }else{
                        forEven[i] = p.index;
                        forOdd[i] = p.index;
                        node.left = p.left;
                        node.right = p.right;
                        break;
                    }
                }
                if(pp==null){
                    continue;
                } else if(pp.val>node.val){
                    pp.left = node;
                }else{
                    pp.right = node;
                }
            }

            int cntOfGoodOdd = 1;
            isGood[isGood.length-1] = 3;
            for(int i= A.length-2;i>=0;i--){
                if(forEven[i]>0 && isGoodOdd(forEven[i])){
                    isGood[i] += 2;
                }
                if(forOdd[i]>0 && isGoodEven(forOdd[i])){
                    isGood[i] += 1;
                    cntOfGoodOdd++;
                }
            }
            return cntOfGoodOdd;
        }

        private boolean isGoodEven(int index){
            return isGood[index]==2 || isGood[index]==3;
        }

        private  boolean isGoodOdd(int index){
            return isGood[index]==1 || isGood[index]==3;
        }
    }
}
