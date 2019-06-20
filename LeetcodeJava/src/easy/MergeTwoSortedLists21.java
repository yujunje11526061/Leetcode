package easy;

public class MergeTwoSortedLists21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = null,tail=null;
            ListNode p=l1,q=l2;
            ListNode temp = null;
            while (p != null && q != null) {
                if(p.val<q.val){
                    temp = p;
                    p = p.next;
                }else{
                    temp = q;
                    q=q.next;
                }
                if (head == null) {
                    head = temp;
                    tail = temp;
                } else{
                    tail.next = temp;
                    tail = temp;
                }
            }
            ListNode pq = p==null?q:p;
            while (pq != null) {
                if (head == null) {
                    head = pq;
                    tail = pq;
                } else{
                    tail.next = pq;
                    tail = pq;
                }
                pq = pq.next;
            }
            return head;
        }
    }
}
