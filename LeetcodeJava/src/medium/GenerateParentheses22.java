package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static GenerateParentheses22 instance = new GenerateParentheses22();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.generateParenthesis(3));
    }

    class Solution {
        private List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            findCombinations("", n, n);
            return list;
        }

        private void findCombinations(String s, int left, int right) {
            if(left==0 && right == 0){
                list.add(s);
                return;
            }
            if(left<right) {
                findCombinations(s + ")", left, right - 1);
            }
            if(left<=right && left>0) {
                findCombinations(s+"(",left-1,right);
            }
        }
    }
}
