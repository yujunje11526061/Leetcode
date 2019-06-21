package medium;

public class InsertionSortList147 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        ListNode nHead;
        ListNode nTail;
        public ListNode insertionSortList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode p = head;
            ListNode pp = null;
            while (p != null) {
                pp = p;
                p = p.next;
                insert(pp);
            }
            return nHead;
        }

        private void insert(ListNode now) {
            if(nHead==null){
                nHead = now;
                nTail = now;
                nTail.next = null;
                return;
            }
            ListNode p = nHead;
            ListNode pp = null;
            while(p!=null && p.val<=now.val){
                pp =p;
                p = p.next;
            }
            if(p==null){
                nTail.next=now;
                nTail = now;
                nTail.next=null;
            }else if(pp==null){
                now.next = nHead;
                nHead = now;
            }else{
                now.next = p;
                pp.next = now;
            }
        }
    }
}
