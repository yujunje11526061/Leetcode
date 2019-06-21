package medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion6 {
    public static ZigZagConversion6 instance = new ZigZagConversion6();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(instance.solution.convert(s,numRows));
    }



    class Solution {
        public String convert(String s, int numRows) {
            List<List<Character>> list = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                list.add(new ArrayList<>());
            }
            int cnt = 0;
            while(cnt<s.length()){
                for (int i = 0; i < numRows && cnt<s.length(); i++) {
                    list.get(i).add(s.charAt(cnt));
                    cnt++;
                }
                for (int j = numRows-2; j>=1  && cnt<s.length(); j--) {
                    list.get(j).add(s.charAt(cnt));
                    cnt++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(List<Character> l:list){
                for(Character c: l){
                    stringBuilder.append(c);
                }
            }
            return stringBuilder.toString();
        }
    }
}
