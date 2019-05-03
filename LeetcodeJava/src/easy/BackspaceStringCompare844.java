package easy;

import java.util.Iterator;
import java.util.LinkedList;

public class BackspaceStringCompare844 {
    public static BackspaceStringCompare844 instance = new BackspaceStringCompare844();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.backspaceCompare("a##c", "#a#c"));
    }

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            LinkedList<Character> s = new LinkedList<>();
            LinkedList<Character> t = new LinkedList<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '#' && !s.isEmpty()) {
                    s.removeLast();
                } else if (c != '#') {
                    s.add(c);
                }
            }
            for (int i = 0; i < T.length(); i++) {
                char c = T.charAt(i);
                if (c == '#' && !t.isEmpty()) {
                    t.removeLast();
                } else if (c != '#') {
                    t.add(c);
                }
            }
            if(s.size()!=t.size()){
                return false;
            }
            Iterator<Character> is = s.iterator();
            Iterator<Character> it = t.iterator();
            while(is.hasNext() && it.hasNext()){
                if(is.next()!=it.next()){
                    return false;
                }
            }
            return true;
        }
    }
}
