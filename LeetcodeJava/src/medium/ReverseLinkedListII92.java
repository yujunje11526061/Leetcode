package medium;

public class ReverseLinkedListII92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode p = head;
            ListNode pp = null;
            int i = 1;
            while (i < m) {
                pp = p;
                p = p.next;
                i++;
            }

            ListNode pn = p.next;
            ListNode nHead = head;
            ListNode tail = pp;
            ListNode nTail = p;
            for (int j = 0; j <= n - m; j++) {
                p.next = pp;
                pp = p;
                p = pn;
                if (pn != null) {
                    pn = pn.next;
                } else {
                    break;
                }
            }
            if(m==1){
                nHead = pp;
                nTail.next = p;
            }else {
                tail.next = pp;
                nTail.next = p;
            }
            return nHead;
        }
    }
}
