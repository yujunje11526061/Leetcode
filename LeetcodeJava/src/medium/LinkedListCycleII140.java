package medium;

public class LinkedListCycleII140 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head==null || head.next==null){
                return null;
            }
            ListNode meet = findMeet(head);
            if(meet==null){
                return null;
            }
            int length = findLength(meet);
            ListNode entrance =findEntrance(head,length);
            return entrance;
        }

        private ListNode findEntrance(ListNode head, int length) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < length; i++) {
                fast = fast.next;
            }
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        private int findLength(ListNode meet) {
            ListNode p = meet;
            int cnt = 0;
            do{
                p = p.next;
                cnt++;
            }while(p!=meet);
            return cnt;
        }

        private ListNode findMeet(ListNode head) {
            ListNode slow=head;
            ListNode fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow==fast){
                    return slow;
                }
            }
            return null;
        }
    }
}
