package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LinkedListComponents817 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int numComponents(ListNode head, int[] G) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int i:G){hashSet.add(i);}

            ListNode p = head;
            int cnt = 0;
            int flag = 0;

            while (p != null) {
                if(hashSet.contains(p.val)){
                    if(flag==0){
                        flag=1;
                        cnt++;
                    }
                }else{
                    flag = 0;
                }
                p = p.next;
            }
            return cnt;
        }
    }

}
