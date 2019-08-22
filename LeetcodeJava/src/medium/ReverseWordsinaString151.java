package medium;

import java.util.Stack;

public class ReverseWordsinaString151 {

    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            Stack<String> stack = new Stack<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != ' ') {
                    stringBuilder.append(s.charAt(j));
                } else {
                    if (stringBuilder.length() == 0) {
                        continue;
                    } else {
                        stack.push(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                }
            }

            if(stringBuilder.length()>0){
                stack.push(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            while(!stack.isEmpty()){
                String temp = stack.pop();
                stringBuilder.append(temp);
                if(!stack.isEmpty()){
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        }

    }

}

