package easy;

public class LongestCommonPrefix14 {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs==null || strs.length==0){
                return "";
            }
            int i=0;
            char c;
            while(true) {
                if(i<strs[0].length()){
                   c = strs[0].charAt(i);
                }else{
                    break;
                }
                for (String str : strs) {
                    if(i<str.length() && c == str.charAt(i)){
                        continue;
                    }else{
                        return strs[0].substring(0,i);
                    }
                }
                i++;
            }
            return strs[0].substring(0,i);
        }
    }
}
