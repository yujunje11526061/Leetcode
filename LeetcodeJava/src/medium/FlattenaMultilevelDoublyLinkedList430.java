package medium;

public class FlattenaMultilevelDoublyLinkedList430 {
    public static FlattenaMultilevelDoublyLinkedList430 instance = new FlattenaMultilevelDoublyLinkedList430();
    public Solution solution = new Solution();
    Node root = new Node(1, null, null, null);

    public static void main(String[] args) {
        Node result = instance.solution.flatten(instance.root);
        System.out.println(result.val);
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    class Solution {
        public Node tail = null;

        public Node flatten(Node head) {
            Node p = head, pp = null;
            while (p != null) {
                if (p.child != null) {
                    flatten(p.child);
                    tail.next = p.next;
                    if (p.next != null) {
                        p.next.prev = tail;
                    }
                    p.child.prev = p;
                    p.next = p.child;
                    p.child = null;
                }
                pp = p;
                p = p.next;
            }
            tail = pp;
            return head;
        }
    }
}
