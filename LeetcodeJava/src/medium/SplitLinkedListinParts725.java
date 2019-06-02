package medium;

public class SplitLinkedListinParts725 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] result = new ListNode[k];
            if (root == null) {
                return result;
            }
            int M = 0;
            ListNode p = root;
            while (p != null) {
                p = p.next;
                M++;
            }
            int shorter = M / k;
            int longer = shorter + 1;

            int cntShorter = (M - longer * k) / (shorter - longer);
            int cntLonger = (M - shorter * k) / (longer - shorter);
            int i = 0;

            p = root;
            while (cntLonger > 0) {
                ListNode head = p;
                ListNode pp = null;
                for (int j = 0; j < longer; j++) {
                    pp = p;
                    p = p.next;
                }
                pp.next = null;
                result[i] = head;
                cntLonger--;
                i++;
            }

            if (shorter == 0) {
                return result;
            }
            while (cntShorter > 0) {
                ListNode head = p;
                ListNode pp = null;
                for (int c = 0; c < shorter; c++) {
                    pp = p;
                    p = p.next;
                }
                pp.next = null;
                result[i] = head;
                cntShorter--;
                i++;
            }
            return result;
        }
    }
}
