package medium;

public class IsSubsequence392 {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s == null || t == null) {
                return false;
            }
            if (s.equals("")) {
                return true;
            }
            if (t.equals("") || t.length()<s.length()) {
                return false;
            }

            int i=0;
            int j = 0;
            boolean flag = false;
            for (; i < s.length() && j < t.length(); i++) {
                for (; j < t.length(); j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        j++;
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    return false;
                }
                flag = false;
            }
            return i<s.length()?false:true;
        }
    }
}
