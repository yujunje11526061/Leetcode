package medium;


public class ScoreofParentheses856 {
    public static ScoreofParentheses856 instance = new ScoreofParentheses856();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s1 = "(()(()))";
        System.out.println(instance.solution.scoreOfParentheses(s1));
    }
    class Solution {
        public int scoreOfParentheses(String S) {
            if(S==null || S.length()==0){
                return 0;
            }
            int l=0;
            int r=0;
            int score = 0;
            int head = 0;
            for(int i=0;i<S.length();i++){
                if(S.charAt(i)=='('){
                    l++;
                }else{
                    r++;
                }
                if(r==l){
                    score += scoreOfGroup(S.substring(head,i+1));
                    head = i+1;
                }else if(r>l){
                    head = i+1;
                }else{
                    continue;
                }
            }
            return score;
        }

        private int scoreOfGroup(String sGroup) {
            if(sGroup.length()==2){
                return 1;
            }
            return 2*scoreOfParentheses(sGroup.substring(1,sGroup.length()));
        }
    }
}
