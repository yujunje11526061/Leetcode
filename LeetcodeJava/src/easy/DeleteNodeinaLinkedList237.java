package easy;

public class DeleteNodeinaLinkedList237 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            ListNode p = node;
            p.val = p.next.val;
            p.next = p.next.next;
        }
    }
}
