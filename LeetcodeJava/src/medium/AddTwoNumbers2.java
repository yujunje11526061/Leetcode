package medium;

public class AddTwoNumbers2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode newHead = null;
            ListNode newTail = null;
            ListNode p = l1;
            ListNode q = l2;
            int addTo = 0;
            while(p!=null && q!= null){
                int res = p.val+q.val + addTo;
                int left = res%10;
                addTo = res/10;
                ListNode now = new ListNode(left);
                if(newHead==null){
                    newHead=now;
                    newTail = now;
                }else{
                    newTail.next = now;
                    newTail = now;
                }
                p=p.next;
                q=q.next;
            }
            ListNode pq = p==null?q:p;
            while(pq!=null){
                int res = pq.val+addTo;
                int left = res%10;
                addTo = res/10;
                ListNode now = new ListNode(left);
                if(newHead==null){
                    newHead=now;
                    newTail = now;
                }else{
                    newTail.next = now;
                    newTail = now;
                }
                pq= pq.next;
            }
            if(addTo>0){
                ListNode now = new ListNode(addTo);
                newTail.next = now;
                newTail = now;
            }
            return newHead;
        }
    }
}
