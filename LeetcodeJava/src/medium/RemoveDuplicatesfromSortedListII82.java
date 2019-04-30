package medium;

public class RemoveDuplicatesfromSortedListII82 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode ppre=null,preNode = head, p = head.next;
            ListNode newHead = head;
            int preVal=head.val;
            while(p!=null){
                while(p!=null && p.val==preVal){
                    p = p.next;
                }
                if(preNode.next==p){
                    ppre = preNode;
                }else{
                    if(ppre==null){
                        newHead = p;
                    }else{
                        ppre.next=p;
                    }
                }
                if(p!=null) {
                    preNode = p;
                    preVal = preNode.val;
                    p = p.next;
                }
            }
            return newHead;
        }
    }
}
