package medium;

public class DeleteOperationforTwoStrings583 {
    public static DeleteOperationforTwoStrings583 instance = new DeleteOperationforTwoStrings583();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String word1 = "eattttt";
        String word2 = "sea";
        System.out.println(instance.solution.minDistance(word1,word2));
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] table = new int[word1.length()+1][word2.length()+1];
            for(int i=1;i<=word1.length();i++){
                for(int j=1;j<=word2.length();j++){
                    int x = table[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1)?1:0);
                    table[i][j] = Integer.max(Integer.max(table[i-1][j], table[i][j-1]), x);
                }
            }
            int longestCommonSubStrings = table[word1.length()][word2.length()];
            return word1.length()+word2.length()-longestCommonSubStrings*2;
        }
    }
}
