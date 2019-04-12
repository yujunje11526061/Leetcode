package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
    public static LetterCombinationsofaPhoneNumber17 instance = new LetterCombinationsofaPhoneNumber17();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = instance.solution.letterCombinations(digits);
        System.out.println(result);
    }
    class Solution {
        private List<String> table = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        private HashMap<Character, String> map = new HashMap<>();
        public List<String> letterCombinations(String digits) {
            if(digits==null || digits.length()==0){
                return new ArrayList<String>();
            }
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");
            collect(0,digits);
            return table;
        }
        private void collect(int p, String digits){
            if(p==digits.length()){
                table.add(sb.toString());
                return;
            }
            String now = map.get(digits.charAt(p));
            for(int i=0;i<now.length();i++){
                sb.append(now.charAt(i));
                collect(p+1,digits);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
