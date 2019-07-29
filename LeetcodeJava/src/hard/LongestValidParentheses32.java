package hard;

public class LongestValidParentheses32 {


    class Solution {

        public int longestValidParentheses(String s) {
            int maxL = 0;
            int l = 0;
            int r = 0;
            Character c;
            for (int i = 0; i <s.length() ; i++) {
                c = s.charAt(i);
                if(c==')'){
                    if(l==r) {
                        l = 0;
                        r = 0;
                    }else{
                        r++;
                        if(l==r) {
                            maxL = maxL < l + r ? l + r : maxL;
                        }
                    }
                } else{
                    l++;
                }
            }

            l = r = 0;
            for (int i = s.length()-1; i>=0 ; i--) {
                c = s.charAt(i);
                if(c=='('){
                    if(l==r) {
                        l = 0;
                        r = 0;
                    }else{
                        r++;
                        if(l==r) {
                            maxL = maxL < l + r ? l + r : maxL;
                        }
                    }
                } else{
                    l++;
                }
            }

            return maxL;
        }
    }
}
