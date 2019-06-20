package medium;

import java.util.Stack;

public class AddTwoNumbersII445 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();

            ListNode p = l1;
            ListNode q = l2;

            while(p!=null){
                stack1.push(p);
                p = p.next;
            }
            while(q!=null){
                stack2.push(q);
                q = q.next;
            }

            ListNode newHead = null;
            ListNode pq= null;
            int addTo = 0;
            while((!stack1.isEmpty())&&(!stack2.isEmpty())){
                p = stack1.pop();
                q = stack2.pop();
                int res = p.val+q.val+addTo;
                addTo = res/10;
                pq = new ListNode(res%10);
                if (newHead == null) {
                    newHead = pq;
                }else{
                    pq.next = newHead;
                    newHead = pq;
                }
            }
            Stack<ListNode> stack = stack1.isEmpty()?stack2:stack1;
            while(!stack.isEmpty()){
                p = stack.pop();
                int res = p.val+addTo;
                addTo = res/10;
                pq = new ListNode(res%10);
                if (newHead == null) {
                    newHead = pq;
                }else{
                    pq.next = newHead;
                    newHead = pq;
                }
            }
            if(addTo>0){
                pq = new ListNode(addTo);
                pq.next = newHead;
                newHead = pq;
            }
            return newHead;
        }
    }
}
