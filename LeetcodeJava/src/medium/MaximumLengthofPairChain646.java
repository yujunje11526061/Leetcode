package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain646 {
    public static MaximumLengthofPairChain646 instance = new MaximumLengthofPairChain646();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(instance.solution.findLongestChain(pairs));
    }
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1[1],o2[1]));
            int cnt = 0;
            int pre = 0x80000000;
            for(int i=0;i<pairs.length;i++){
                int[] pair = pairs[i];
                if(pair[0]>pre){
                    cnt++;
                    pre = pair[1];
                }
            }
            return cnt;
        }
    }
}
