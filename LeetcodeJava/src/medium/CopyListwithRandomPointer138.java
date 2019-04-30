package medium;

public class CopyListwithRandomPointer138 {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            copyListRegardlessOfRandomPointer(head);
            copyRandomPointer(head);
            return split(head);
        }

        private void copyListRegardlessOfRandomPointer(Node head) {
            Node p = head;
            while (p != null) {
                Node newNode = new Node(p.val, p.next, p.random);
                p.next = newNode;
                p = newNode.next;
            }
        }

        private void copyRandomPointer(Node head) {
            Node p = head.next;
            while (p.next != null) {
                if(p.random!=null) {
                    p.random = p.random.next;
                }
                p = p.next.next;
            }
            if(p.random!=null) {
                p.random = p.random.next;
            }
        }

        private Node split(Node head) {
            Node newHead = null, np = null;
            Node p = head;
            while (p != null) {
                if (newHead == null) {
                    newHead = p.next;
                    np = p.next;
                }else {
                    np.next = p.next;
                    np = p.next;
                }
                p.next = np.next;
                p = p.next;
            }
            return newHead;
        }
    }
}
