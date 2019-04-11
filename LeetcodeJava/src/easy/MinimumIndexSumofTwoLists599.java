package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MinimumIndexSumofTwoLists599 {
    public static MinimumIndexSumofTwoLists599 instance = new MinimumIndexSumofTwoLists599();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result = instance.solution.findRestaurant(list1,list2);
        System.out.println(Arrays.toString(result));
    }

    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            HashMap<String, Integer> map= new HashMap<>();
            ArrayList<String> al = new ArrayList<>();
            int sum = 0x7fffffff;
            for(int i=0;i< list1.length;i++){
                map.put(list1[i],i);
            }
            for(int j=0;j<list2.length;j++){
                int thisSum= map.getOrDefault(list2[j],10000000)+j;
                if(thisSum<sum){
                    al.clear();
                    al.add(list2[j]);
                    sum = thisSum;
                }else if(thisSum==sum){
                    al.add(list2[j]);
                }
            }
            return al.toArray(new String[0]);
        }
    }
}
