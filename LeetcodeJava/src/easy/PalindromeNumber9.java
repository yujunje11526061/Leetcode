package easy;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeNumber9 {
    class Solution {


        //将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
        //但是，如果反转后的数字大于 int.MAX，我们将遇到整数溢出问题。
        //
        //为了避免数字反转可能导致的溢出问题，为什么不考虑只反转int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
        //我们将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
        //当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字

        public boolean isPalindrome(int x) {
            if(x<0){
                return false;
            }
            if(x==0){
                return true;
            }
            Deque<Integer> deque = new LinkedList<>();
            while(x>0){
                deque.addLast(x%10);
                x /= 10;
            }
            while(deque.size()>1){
                int a = deque.pollFirst();
                int b = deque.pollLast();
                if(a!=b){
                    return false;
                }
            }
            return true;
        }
    }
}
