package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf315 {
    public static CountofSmallerNumbersAfterSelf315 instance = new CountofSmallerNumbersAfterSelf315();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(instance.solution.countSmaller(nums));
    }

    class Solution1 {
        // 二叉搜索树法，最坏情况为O(n^2)
        class Node {
            int val;
            int cnt = 0; // 左子树有多少节点
            Node left = null;
            Node right = null;

            public Node(int val) {
                this.val = val;
            }
        }

        List<Integer> list = new LinkedList<>();

        public List<Integer> countSmaller(int[] nums) {
            ArrayList<Integer> result = new ArrayList<>();
            Node root = null;
            for (int i = nums.length - 1; i >= 0; i--) {
                Node node = new Node(nums[i]);
                Node p = root, pp = null;
                int count = 0;
                if (root == null) {
                    root = node;
                    list.add(0, 0);
                    continue;
                }
                while (p != null) {
                    if (node.val <= p.val) {
                        p.cnt++;
                        pp = p;
                        p = p.left;
                    } else {
                        count += p.cnt + 1;
                        pp = p;
                        p = p.right;
                    }
                }
                if (pp.val >= node.val) {
                    pp.left = node;
                } else {
                    pp.right = node;
                }
                list.add(0, count);
            }
            return list;
        }
    }

    class Solution {
        // 归并排序法，每次并时，右边先拿几个加几个，时间复杂度稳定O(nlogn)
        public class Node {
            int val;
            int index;
            int cnt = 0;

            public Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            Node[] table1 = new Node[nums.length];
            Node[]table2 = new Node[nums.length];
            for (int i = 0; i < nums.length; i++) {
                table1[i] = new Node(nums[i], i);
            }
            // 以下循环是手写归并的核心难点。
            int len = 1; // 已经归并完的小段长度
            while (len < nums.length) {
                int i;
                for (i = 0; i + len < nums.length; i += 2 * len) {
                    merge(i, i + len - 1, i + len, Math.min(i + 2 * len - 1, nums.length - 1), table1, table2);
                }
                while(i<nums.length && i+len>=nums.length){
                    table2[i] = table1[i];
                    i++;
                }
                Node[] tmp = table1;
                table1 = table2;
                table2 = tmp;
                len *= 2;
            }
            List<Integer> result = new ArrayList<>(nums.length);
            for(int i=0;i<nums.length;i++){
                result.add(0);
            }
            for (Node node : table1) {
                result.set(node.index, node.cnt);
            }
            return result;

        }

        private void merge(int s1, int e1, int s2, int e2, Node[] table1, Node[] table2) {
            int p = s1, q = s2, k=s1;
            int cnt=0; // 记录已经从右半段拿了几个了
            while(p<=e1 && q<=e2){
                if(table1[p].val<=table1[q].val){ // 从左半段拿
                    table1[p].cnt += cnt;
                    table2[k] = table1[p];
                    p++;
                }else{ // 从右半段拿
                    cnt++;
                    table2[k] = table1[q];
                    q++;
                }
                k++;
            }
            while(p<=e1){
                table1[p].cnt += cnt;
                table2[k] = table1[p];
                p++;
                k++;
            }
            while(q<=e2){
//                cnt++;
                table2[k] = table1[q];
                q++;
                k++;
            }

        }
    }
}
