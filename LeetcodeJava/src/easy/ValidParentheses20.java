package easy;

import java.util.Stack;

public class ValidParentheses20 {

    class Solution {
        public boolean isValid(String s) {
            if(s==null || (s.length() & 1)==1){
                return false;
            }
            Stack<Character> stack =  new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                }else if( c==']'){
                    if(stack.isEmpty() ||stack.pop()!='['){
                        return false;
                    }
                }else if(c=='}'){
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                }else{
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
}
