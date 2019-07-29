package hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveDuplicateLetters316 {

    public static RemoveDuplicateLetters316 instance = new RemoveDuplicateLetters316();
    public Solution solution = new Solution();

    public static void main(String[] args) {
//        String s = "bcabc";
        String s = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
        System.out.println(instance.solution.removeDuplicateLetters(s));
    }

    class Solution {
        public String removeDuplicateLetters(String s) {
            if(s==null){
                return null;
            }
            if(s.length()<=1){
                return s;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.merge(s.charAt(i), 1, Integer::sum);
            }

            Deque<Character> deque = new LinkedList<>(); // 递增

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <s.length() ; i++) {
                Character c = s.charAt(i);
                int count = map.get(c);
                if(count==-1){ // 表示该字符已经用过
                    continue;
                }
                if(count==1){ // 该字符只剩一个，必须加入最终结果了
                    clear(deque,stringBuilder,c,map);
                }else{ // 该字符还有很多，先暂存下
                    map.put(c,count-1);
                    // 如果队列中已经有该字母了，则不用存了。
                    boolean flag = false;
                    for(Character p:deque){
                        if(p.equals(c)){
                            flag=true;
                        }
                    }
                    if(!flag) {
                        addToDeque(deque, c);
                    }
                }
            }

            return stringBuilder.toString();

        }

        private void addToDeque(Deque<Character> deque, Character c) {
            while(!deque.isEmpty()){
                if(deque.getLast()>=c){
                    deque.removeLast();
                }else{
                    break;
                }
            }
            deque.addLast(c);
        }

        private void clear(Deque<Character> deque, StringBuilder stringBuilder, Character c, Map<Character, Integer> map) {
            while(!deque.isEmpty()){
                Character head = deque.pollFirst();
                if(head<c){
                    stringBuilder.append(head);
                    map.put(head,-1);
                }else if(head.equals(c)){
                    stringBuilder.append(head);
                    map.put(head,-1);
                    return;
                }
            }
            stringBuilder.append(c);
            map.put(c,-1);
        }
    }
}
