package easy;

public class RemoveDuplicatesfromSortedList83 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            ListNode p = head;
            ListNode newHead =null;
            ListNode tail = null;
            while(p!=null){
                if(newHead==null){
                    newHead = p;
                    tail = p;
                }else {
                    if (p.val != tail.val) {
                        tail.next = p;
                        tail = p;
                    }
                }
                p = p.next;
            }
            if(tail!=null) {
                tail.next = null;
            }
            return newHead;
        }
    }
}
