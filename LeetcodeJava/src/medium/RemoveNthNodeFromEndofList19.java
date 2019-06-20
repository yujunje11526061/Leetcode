package medium;

public class RemoveNthNodeFromEndofList19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode before = head;
            int i=0;
            for (; i < n && before!=null; i++) {
                before = before.next;
            }
            if(i<n){
                return head;
            }else{
                ListNode after = head;
                ListNode pp = null;
                while(before!=null){
                    before = before.next;
                    pp = after;
                    after = after.next;
                }
                if(pp==null){
                    return head.next;
                }else{
                    pp.next = after.next;
                    return head;
                }
            }
        }
    }
}
