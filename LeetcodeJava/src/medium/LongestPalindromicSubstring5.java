package medium;

public class LongestPalindromicSubstring5 {
    public static LongestPalindromicSubstring5 instance = new LongestPalindromicSubstring5();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "aaabaaaa";
        System.out.println(instance.solution.longestPalindrome(s));
    }

    class Solution {
        int[] coverLength; // 每个位置的羽翼长度
        int maxCenter = 0; // 前向覆盖达到最远的覆盖中心
        int maxIndex = 0; // 前向覆盖最远能达到的坐标
        int maxL = 1;
        int maxLC = 0;

        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            if (s.length() <= 1) {
                return s;
            }
            // 在每个字符前后填充稻草，从而适配结果为奇或为偶的任意情况，不影响回文性。
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('#');
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i)).append('#');
            }
            s = stringBuilder.toString();

            // 马拉车算法，看前面最远的羽翼的覆盖范围
            coverLength = new int[s.length()];
            coverLength[0]=0;
            for (int i = 1; i < s.length(); i++) {
                int temp,j;
                if (maxIndex <= i) { //前面可参考的内容没有，直接中心扩展
                    temp = 1;
                    j = 1;
                } else {
                    // 镜像位置的羽翼长度和i到maxIndex这一部分的较小者可以复用
                    int mirror = 2*maxCenter-i;
                    int reusable = Integer.min(maxIndex-i,coverLength[mirror]);
                    temp = reusable * 2 + 1;
                    j = reusable+1;
                }
                find(s,temp,i,j);
            }
            int coverLen = (maxL-1)/2; // maxL必定为奇数
            StringBuilder result = new StringBuilder();
            for(int k=maxLC-coverLen+1;k<=maxLC+coverLen;k += 2){
                result.append(s.charAt(k));
            }
            return result.toString();
        }

        private void find(String s, int temp, int i, int j) {
            for (; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    temp += 2;
                } else {
                    break;
                }
            }
            j--;
            if (maxIndex < i + j) {
                maxIndex = i + j;
                maxCenter = i;
            }
            if (maxL < temp) {
                maxL = temp;
                maxLC = i;
            }
            coverLength[i] = j;
        }

    }

    // 普通解法，O(N^2),空间O(1)，注意奇偶不同处理。
    class Solution2 {
        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            if (s.length() <= 1) {
                return s;
            }
            int maxL = 1;
            String maxPS = s.charAt(0) + "";
            for (int i = 0; i < s.length(); i++) {
                int temp = 1;
                int j = 1;
                for (; i - j >= 0 && i + j < s.length(); j++) {
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        temp += 2;
                    } else {
                        break;
                    }
                }
                j--;
                if (maxL < temp) {
                    maxL = temp;
                    maxPS = s.substring(i - j, i + j + 1);
                }
            }

            for (int i = 1; i < s.length(); i++) {
                int temp = 0;
                int j = 1;
                for (; i - j >= 0 && i + j - 1 < s.length(); j++) {
                    if (s.charAt(i - j) == s.charAt(i + j - 1)) {
                        temp += 2;
                    } else {
                        break;
                    }
                }
                j--;
                if (maxL < temp) {
                    maxL = temp;
                    maxPS = s.substring(i - j, i + j);
                }
            }
            return maxPS;
        }
    }

}
