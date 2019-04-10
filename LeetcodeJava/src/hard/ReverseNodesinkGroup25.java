package hard;

public class ReverseNodesinkGroup25 {

    public static ReverseNodesinkGroup25 instance = new ReverseNodesinkGroup25();
    public Solution solution =new Solution();

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next=b;
        ListNode c = new ListNode(3);
        b.next=c;
        ListNode d = new ListNode(4);
        c.next=d;
        ListNode e = new ListNode(5);
        d.next=e;
        int k = 2;
        ListNode result = instance.solution.reverseKGroup(a,k);
        ListNode q = result;
        while(q!=null){
            System.out.println(q.val);
            q = q.next;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1) {
                return head;
            }
            ListNode p = head, pn = null, prev = null, prevHeadOfThisGroup = null;
            ListNode newHead = null, newTail = null;
            int cnt = 0;
            while(p!=null){
                cnt++;
                p=p.next;
            }
            if(cnt<k){
                return head;
            }
            p = head;
            int group = cnt/k;
            for(int i=0;i<group;i++){
                prevHeadOfThisGroup = p;
                prev = null;
                pn = p.next;
                int j=0;
                while(j<k){
                    j++;
                    p.next = prev;
                    prev = p;
                    p = pn;
                    pn = p==null?null:p.next;
                }
                if(newHead==null){
                    newHead=prev;
                }else{
                    newTail.next=prev;
                }
                newTail = prevHeadOfThisGroup;
            }
            newTail.next=p;
            return newHead;
        }
    }

}

