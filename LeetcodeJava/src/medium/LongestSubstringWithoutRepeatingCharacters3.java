package medium;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static LongestSubstringWithoutRepeatingCharacters3 instance = new LongestSubstringWithoutRepeatingCharacters3();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(instance.solution.lengthOfLongestSubstring(s));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s==null || s.length()==0){
                return 0;
            }
            Set<Character> set = new HashSet<>();
            int i=0,j=0;
            int maxL = 0;
            for(;i<s.length();i++){
                char c = s.charAt(i);
                if(set.contains(c)) {
                    for(;s.charAt(j)!=c;j++){
                        set.remove(s.charAt(j));
                    }
                    j++;
                }else{
                    set.add(c);
                    int len = i-j;
                    maxL = len > maxL ? len: maxL;

                }
            }
            return maxL+1;
        }
    }
}
