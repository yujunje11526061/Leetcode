package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList143 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            Deque<ListNode> deque = new ArrayDeque<>();
            ListNode p = head;
            while (p != null) {
                deque.addLast(p);
                p = p.next;
            }
            ListNode newHead = null;
            ListNode tail = null;
            ListNode pp = null;
            while (!deque.isEmpty()) {
                pp = deque.pollFirst();
                p = deque.pollLast();
                pp.next = p;
                if (newHead == null) {
                    newHead = pp;
                    tail = p;
                } else {
                    tail.next = pp;
                    tail = p;
                }
            }
            if (tail != null) {
                tail.next = null;
            }
            head = newHead;
        }
    }
}
