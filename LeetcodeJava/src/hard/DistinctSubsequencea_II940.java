package hard;

import java.util.HashMap;

public class DistinctSubsequencea_II940 {
    public static DistinctSubsequencea_II940 instance = new DistinctSubsequencea_II940();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] S = {"blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr", "aaa", "asc", "lee", "aba", "bebb"};
        for (String s : S) {
            int result = instance.solution.distinctSubseqII(s);
            System.out.println(result);
        }
    }

    // Java中 -5%6为-5，Python中为1
    class Solution {
        public int distinctSubseqII(String S) {
            if (S.isEmpty()) {
                return 0;
            }
            long tot = 0;
            long mod = (long) 1000000000 + 7;
            HashMap<Character, Long> mp = new HashMap<>();
            for (int i = 0; i < S.length(); i++) {
                long cnt = mp.getOrDefault(S.charAt(i), Long.valueOf(0)) % mod;
                mp.put(S.charAt(i), tot + 1); // 最新的以此结尾的 = 在原来的tot个后面添加此字符+只有这一个字符的
                tot = (tot * 2 + 1 - cnt) % mod; // 新增在后面添加此字符后以此结尾的+只有这一个字符的-此前已经以此结尾的这些重复计算的
            }
            return (int) ((tot + mod) % mod);
        }
    }
}
