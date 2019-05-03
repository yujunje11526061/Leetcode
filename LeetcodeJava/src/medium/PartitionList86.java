package medium;

public class PartitionList86 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode p=head,pp=null,newHead=null, np = null;
            while(p!=null){
                if(p.val<x){
                    if(newHead==null){
                        newHead = np = p;
                    }else{
                        np.next = p;
                        np = p;
                    }
                    if(pp!=null){
                        pp.next=p.next;
                    }else{
                        head = p.next;
                    }
                    p = p.next;
                }else{
                    pp=p;
                    p=p.next;
                }
            }
            if(newHead==null){
                return head;
            }else {
                np.next=head;
                return newHead;
            }
        }
    }
}
