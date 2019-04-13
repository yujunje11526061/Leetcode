package easy;

import java.util.Arrays;

public class ImplementstrStr28 {
    public static ImplementstrStr28 instance = new ImplementstrStr28();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(instance.solution.strStr(haystack, needle));
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null || needle.length() > haystack.length()) {
                return -1;
            }
            if (needle.isEmpty()) {
                return 0;
            }

//            return haystack.indexOf(needle);
            int[] table = new int[needle.length()];
            table[0] = -1;
            int p = -1;
            // p为此前最大前后缀长度，即0...i-1里面最大的，p不能在每次循环前用p=table[i-1]取。
            // 由于下面的if中为了优化多跳了一步，且表中还有-1，即表中值并不是此前最大前后缀长度（最少为0，怎么能-1呢），而是匹配时的模式串中的对齐位置。
            // 故需要额外一个变量动态记录此前的最大相同前、后缀长度。

            for (int i = 1; i < needle.length();i++) {
//                int p = table[i-1];
                while (p >= 0 && needle.charAt(p) != needle.charAt(i - 1)) {
                    p = table[p];
                }
                p++;
                if (needle.charAt(p) == needle.charAt(i)) {
                    table[i] = table[p];
                }
                else{
                    table[i] = p;
                }
            }
//            System.out.println(needle);
//            System.out.println(Arrays.toString(table));
            int i = 0, j = 0;
            for (; i < haystack.length() && j < needle.length(); ) {
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = table[j];
                }
            }
            if (j < needle.length()) {
                return -1;
            }
            return i - j;
        }
    }
}
