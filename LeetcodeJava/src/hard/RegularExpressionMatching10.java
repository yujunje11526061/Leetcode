package hard;

public class RegularExpressionMatching10 {
    public static RegularExpressionMatching10 instance = new RegularExpressionMatching10();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(instance.solution.isMatch(s, p));
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }

            // 因为dp中的0代表空串，故字符串中的第i个字符，对应的dp表的下标为i+1
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

            // 初始化
            // Case 1：有一个为空串的情况。都为空是true
            // Case 2: s为空时，只有p为 字符* 交替的形式 才为true
            // Case 3: p为空s不为空都是false，无需初始化，布尔数组默认为false

            // Case 1： 都为空
            dp[0][0] = true;

            // Case 2： 仅s为空，检查p是否为 字符* 交替的形式
            for (int i = 0; i < p.length(); i++) {
                // *号前面的字符匹配0次
                if (p.charAt(i) == '*' && i - 1 >= 0 && p.charAt(i - 1) != '*') {
                    dp[0][i + 1] = dp[0][i - 1];
                    // dp[0][i + 1] = dp[0][i - 2 + 1]; 实际是这样过去的。。下标很容易写错
                }
            }

            // 关键在于p遇到*号怎么处理
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else if (p.charAt(j) == '*') {
                        // 排除*打头或者**相连的情况
                        if (j - 1 < 0 || p.charAt(j - 1) == '*') {
                            dp[i + 1][j + 1] = false;
                            continue;
                        }

                        // *号匹配k次，最少0次，最多i+1次，分情况讨论

                        // 匹配0次
                        if (dp[i + 1][j - 1]) {
                            dp[i + 1][j + 1] = true;
                            continue;
                        }
                        // 匹配大于0次。若前一个是'.'，则随便匹配
                        if (p.charAt(j - 1) == '.') {
                            for (int k = 1; k <= i + 1; k++) {
                                if (dp[i - k + 1][j - 1]) {
                                    dp[i + 1][j + 1] = true;
                                    break;
                                }
                            }
                        }
                        // 匹配大于0次。若前一个不是'.'，则这k个字符都得和p.charAt(j-1)相同
                        boolean flag = true;
                        for (int k = 1; k <= i + 1 && flag; k++) {
                            if (s.charAt(i - k + 1) != p.charAt(j - 1)) {
                                flag = false;
                            }
                            if (dp[i - k + 1][j - 1] && flag) {
                                dp[i + 1][j + 1] = true;
                                break;
                            }
                        }
                    } else {
                        dp[i + 1][j + 1] = dp[i][j] && (s.charAt(i) == p.charAt(j));
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
