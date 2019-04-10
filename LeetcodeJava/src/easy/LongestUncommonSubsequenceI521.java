package easy;

public class LongestUncommonSubsequenceI521 {
    public static LongestUncommonSubsequenceI521 instance = new LongestUncommonSubsequenceI521();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String a = "aba";
        String b = "cbc";
        int result = instance.solution.findLUSlength(a,b);
        System.out.println(result);
    }

    class Solution {
        public int findLUSlength(String a, String b) {
            if(a.length()!=b.length()){
                return a.length()>b.length()?a.length():b.length();
            }
            else {
                return a.equals(b)?-1:a.length();
            }
        }
    }
}
