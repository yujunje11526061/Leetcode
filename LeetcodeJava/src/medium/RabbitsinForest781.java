package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RabbitsinForest781 {
    public static RabbitsinForest781 instance = new RabbitsinForest781();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] answer = {1,1,1,1,1,1,2,2,3,3,4};
        System.out.println(instance.solution.numRabbits(answer));
    }


    class Solution {
//        public int numRabbits(int[] answers) {
//            if(answers==null|| answers.length==0){
//                return 0;
//            }
//            HashMap<Integer, Integer> hashMap = new HashMap<>();
//            int cnt = 0;
//            for(int x:answers){
//                if(x==0){
//                    cnt++;
//                }else if(hashMap.getOrDefault(x,0)==x+1){
//                    cnt += x+1;
//                    hashMap.put(x,1);
//                }else{
//                    hashMap.merge(x,1,Integer::sum);
//
//                }
//            }
//            for (int x:hashMap.keySet()) {
//                cnt += x+1;
//            }
//            return cnt;
//        }
//    }

        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            int num = 0;
            for (int answer : answers) {
                if (map.containsKey(answer) && map.get(answer) > 0) {
                    map.put(answer, map.get(answer) - 1);
                } else {
                    num += answer + 1;
                    map.put(answer, answer);
                }
            }
            return num;
        }
    }
}
