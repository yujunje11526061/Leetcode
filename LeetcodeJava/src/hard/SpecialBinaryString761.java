package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString761 {
    public static SpecialBinaryString761 instance = new SpecialBinaryString761();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String S  = "11011000";
        System.out.println(instance.solution.makeLargestSpecial(S));
    }
    class Solution {
        public String makeLargestSpecial(String S) {
            int cnt=0,i=0;
            List<String> list = new ArrayList<>();
            for(int j=0;j<S.length();j++){
                if(S.charAt(j)=='1'){
                    cnt++;
                }else{
                    cnt--;
                }
                if(cnt==0){
                    list.add('1'+makeLargestSpecial(S.substring(i+1,j))+'0');
                    i = j+1;
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            return String.join("",list);
        }
    }
}
