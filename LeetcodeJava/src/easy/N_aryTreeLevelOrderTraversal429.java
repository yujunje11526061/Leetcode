package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal429 {


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<Node> q = new LinkedList<>();
            q.add(root);
            int c0 = 1;
            int c1 = 0;
            boolean flag = true;
            List<Integer> l = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            while (!q.isEmpty()) {
                Node p = q.removeFirst();
                l.add(p.val);
                if (flag) {
                    c0--;
                    for (Node child : p.children) {
                        q.add(child);
                        c1++;
                    }
                    if (c0 == 0) {
                        flag = false;
                        result.add(l);
                        l = new ArrayList<>();
                    }
                } else {
                    c1--;
                    for (Node child : p.children) {
                        q.add(child);
                        c0++;
                    }
                    if (c1 == 0) {
                        flag = true;
                        result.add(l);
                        l = new ArrayList<>();
                    }
                }
            }
            return result;
        }
    }
}