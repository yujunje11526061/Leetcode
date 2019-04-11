package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordPattern290 {
    public static WordPattern290 instance = new WordPattern290();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog     cat dog";
        boolean result = instance.solution.wordPattern(pattern, str);
        System.out.println(result);
    }

    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] ss = str.split(" +");
            if (pattern.length() != ss.length) {
                return false;
            }
            HashMap<Character, String> map = new HashMap<Character, String>();
            HashSet<String> set = new HashSet<String>();
            for (int i = 0; i < pattern.length(); i++) {
                char p = pattern.charAt(i);
                if (map.containsKey(p) && !map.get(p).equals(ss[i])) {
                    return false;
                } else if (!map.containsKey(p)) {
                    if(set.contains(ss[i])){
                        return false;
                    }
                    map.put(p, ss[i]);
                    set.add(ss[i]);
                }
            }
            return true;
        }
    }
}
