package medium;

public class RotateList61 {
    public static RotateList61 instance = new RotateList61();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int k = 2;
        ListNode head = new ListNode(1);
        ListNode result = instance.solution.rotateRight(head, k);
        System.out.println(result.val);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null){
                return null;
            }
            ListNode p = head, pp = null;
            int cnt = 0;
            while (p != null) {
                p = p.next;
                cnt++;
            }
            k = k % cnt;
            int left = cnt - k;
            int i = 0;
            p = head;
            while (i < left) {
                i++;
                pp = p;
                p = p.next;
            }
            if (p == null) {
                return head;
            }
            while (p.next != null) {
                p = p.next;
            }
            p.next = head;
            head = pp.next;
            pp.next = null;
            return head;
        }
    }
}
