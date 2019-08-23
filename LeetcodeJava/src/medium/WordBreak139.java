package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] result = new boolean[s.length()];
            for (int i = 0; i <s.length() ; i++) {
                for (int j = 0; j <= i; j++) {
                    if(i==j && set.contains(s.substring(0,i+1))){
                        result[i] = true;
                        break;
                    }
                    if(i>j && result[i-j-1] && set.contains(s.substring(i-j,i+1))){
                        result[i] = true;
                        break;
                    }
                }
            }
            return result[s.length()-1];
        }

    }
}
