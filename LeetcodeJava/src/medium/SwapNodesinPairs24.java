package medium;

public class SwapNodesinPairs24 {
    public static SwapNodesinPairs24 instance = new SwapNodesinPairs24();
    public Solution solution =new Solution();

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode result = instance.solution.swapPairs(a);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode a = null;
            ListNode b = null;
            ListNode p = head;
            ListNode newHead = null;
            ListNode tail = null;
            while (p != null && p.next != null) {
                a = p;
                b = p.next;
                p = b.next;
                b.next = a;
                if (newHead == null) {
                    newHead = b;
                    tail = a;
                } else {
                    tail.next = b;
                    tail = a;
                }
            }
            if (p != null) {
                tail.next = p;
                tail = p;
            }
            tail.next = null;
            return newHead;
        }
    }
}
