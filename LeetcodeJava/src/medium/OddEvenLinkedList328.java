package medium;

public class OddEvenLinkedList328 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode h1 = null;
            ListNode h2 = null;
            ListNode t1 = null;
            ListNode t2 = null;
            ListNode p = head;
            while(p!=null && p.next!=null){
                if(h1==null){
                    h1=p;
                    t1 = p;
                }else{
                    t1.next = p;
                    t1 = p;
                }
                p = p.next;
                if(h2==null){
                    h2=p;
                    t2 = p;
                }else{
                    t2.next = p;
                    t2 = p;
                }
                p = p.next;
            }
            if (p != null) {
                t1.next = p;
                t1 = p;
            }
            t1.next=h2;
            t2.next = null;
            return h1;
        }
    }
}
