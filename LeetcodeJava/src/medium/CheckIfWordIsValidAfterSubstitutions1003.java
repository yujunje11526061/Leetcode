package medium;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions1003 {

    class Solution {
        public boolean isValid(String S) {
            if(S==null || S.length()<3){
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if(c=='c'){
                    if(stack.isEmpty() || stack.peek()!='b'){
                        return false;
                    }else{
                        stack.pop();
                        if(stack.isEmpty() || stack.peek() != 'a'){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                }else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
    }
}
