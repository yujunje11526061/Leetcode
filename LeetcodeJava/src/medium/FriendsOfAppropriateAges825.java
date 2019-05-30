package medium;

import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAges825 {

    public static FriendsOfAppropriateAges825 instance = new FriendsOfAppropriateAges825();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] ages= {20,30,100,110,120};
        int result = instance.solution.numFriendRequests(ages);
        System.out.println(result);
    }

    class Solution {
        public int numFriendRequests(int[] ages) {
            Map<Integer,Integer> map= new HashMap<>();
            for (int age : ages) {
                map.merge(age,1,Integer::sum);
            }
            int cnt=0;
            for(Map.Entry<Integer,Integer> entry1: map.entrySet()){

                for(Map.Entry<Integer,Integer> entry2: map.entrySet()){
                    if(entry1.getKey().equals(entry2.getKey())){
                        cnt += isOK(entry1.getKey(),entry2.getKey())*entry1.getValue()*(entry1.getValue()-1);
                    }else{
                        cnt += isOK(entry1.getKey(),entry2.getKey())*entry1.getValue()*entry2.getValue();
                    }
                }
            }
            return cnt;
        }

        private int isOK(int a,int b){
            if((float)b<=0.5*a+7){return 0;}
            if(b>a){return 0;}
            return 1;
        }
    }
}
