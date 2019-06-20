package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergekSortedLists23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length==0) {
                return null;
            }
            List<ListNode> dynamicList = new ArrayList<>(Arrays.asList(lists));
            List<ListNode> temp = new ArrayList<>();
            while(dynamicList.size()>1){
                for (int i = 0; i < dynamicList.size(); i +=2) {
                    ListNode tempList=null;
                    if(i+1<dynamicList.size()) {
                        tempList = mergeTwoLists(dynamicList.get(i), dynamicList.get(i + 1));
                    }else{
                        tempList = dynamicList.get(i);
                    }
                    temp.add(tempList);
                }
                List<ListNode> swap = temp;
                temp = dynamicList;
                dynamicList = swap;
                temp.clear();
            }
            return dynamicList.get(0);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = null,tail=null;
            ListNode p=l1,q=l2;
            ListNode temp = null;
            while (p != null && q != null) {
                if(p.val<q.val){
                    temp = p;
                    p = p.next;
                }else{
                    temp = q;
                    q=q.next;
                }
                if (head == null) {
                    head = temp;
                    tail = temp;
                } else{
                    tail.next = temp;
                    tail = temp;
                }
            }
            ListNode pq = p==null?q:p;
            while (pq != null) {
                if (head == null) {
                    head = pq;
                    tail = pq;
                } else{
                    tail.next = pq;
                    tail = pq;
                }
                pq = pq.next;
            }
            return head;
        }
    }
}
