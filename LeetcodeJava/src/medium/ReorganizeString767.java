package medium;

import java.util.*;

public class ReorganizeString767 {
    public static ReorganizeString767 instance = new ReorganizeString767();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String S = "vvvlo";
        System.out.println(instance.solution.reorganizeString(S));
    }

    class Solution {
        public String reorganizeString(String S) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                map.merge(c,1, Integer::sum);
            }
            PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
            for (Map.Entry<Character,Integer> entry: map.entrySet()) {
                priorityQueue.add(entry);
            }

            StringBuilder stringBuilder = new StringBuilder();

            while(priorityQueue.size()>1) {
                Map.Entry<Character, Integer> entry1 = priorityQueue.poll();
                Map.Entry<Character, Integer> entry2 = priorityQueue.poll();
                entry1.setValue(entry1.getValue()-1);
                entry2.setValue(entry2.getValue()-1);
                stringBuilder.append(entry1.getKey());
                stringBuilder.append(entry2.getKey());
                if(entry1.getValue()>0){
                    priorityQueue.offer(entry1);
                }
                if(entry2.getValue()>0){
                    priorityQueue.offer(entry2);
                }
            }

            if(priorityQueue.size()==1){
                Map.Entry<Character,Integer> entry = priorityQueue.poll();
                if(entry.getValue()>1){
                    return "";
                }else{
                    stringBuilder.append(entry.getKey());
                }
            }
            return stringBuilder.toString();

        }
    }
}
