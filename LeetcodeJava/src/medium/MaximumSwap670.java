package medium;

import java.util.ArrayList;

public class MaximumSwap670 {
    public static MaximumSwap670 instance = new MaximumSwap670();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int num = 98368;
        int result = instance.solution.maximumSwap(num);
        System.out.println(result);
    }

    // 还有一空空间换时间的做法，贪婪思想，在右边找最大的数，如果不唯一，则尽可能右边去
    // 故扫描一遍，记录某个数最右的位置，然后从左往右扫描，从[9,本身)检查，如果右边找到一个比自身大的，直接交换就是最优解。
    class Solution {
        public int maximumSwap(int num) {
            ArrayList<Integer> revlist = new ArrayList<>();
            while (num > 0) {
                revlist.add(num % 10);
                num = num / 10;
            }
            ArrayList<Integer> stack = new ArrayList<>();
            boolean flag1 = false; // 本轮是否交换
            int a = -1;
            int b = -1;
            for (int i = revlist.size() - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    int top = stack.size() - 1;
                    while (top >= 0 && revlist.get(stack.get(top)) < revlist.get(i)) {
                        flag1 = true;
                        int p = stack.remove(top);
                        a = a > p ? a : p;
                        top--;
                    }
                    if (flag1) {
                        b = i;
                        stack.add(i);
                        flag1 = false;
                    } else {
                        if (a==-1) {
                            stack.add(i);
                        }
                        else if (revlist.get(stack.get(top)) == revlist.get(i)) {
                            b = i;
                        }
                    }
                }
            }
            if (a >= 0) {
                int c = revlist.get(a);
                revlist.set(a, revlist.get(b));
                revlist.set(b, c);
            }
            int result = 0;
            for (int j = revlist.size() - 1; j >= 0; j--) {
                result = result * 10 + revlist.get(j);
            }
            return result;
        }
    }
}

