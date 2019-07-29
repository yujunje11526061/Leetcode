package hard;

public class WildcardMatching44 {
    public static WildcardMatching44 instance = new WildcardMatching44();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";

        System.out.println(instance.solution.isMatch(s, p));
    }


    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;  // 空传匹配空串

            // 空模式串与目标串匹配
            for (int i = 0; i < s.length(); i++) {
                dp[i + 1][0] = false;
            }

            // 模式串与空串匹配
            for (int i = 0; i < p.length(); i++) {
                if (dp[0][i] && p.charAt(i) == '*') {
                    dp[0][i + 1] = true;
                } else {
                    dp[0][i + 1] = false;
                }
            }

            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i][j]) {
                        dp[i + 1][j + 1] = true;
                    } else if (p.charAt(j) == '*' && (dp[i][j + 1] || dp[i + 1][j])) {
                        dp[i + 1][j + 1] = true;

                    } else {
                        dp[i + 1][j + 1] = false;
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
