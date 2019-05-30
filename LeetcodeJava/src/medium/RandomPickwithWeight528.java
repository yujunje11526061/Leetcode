package medium;

import java.util.Random;

public class RandomPickwithWeight528 {

    class Solution {
        private long[] table;
        private long MAX;

        public Solution(int[] w) {
            this.table = new long[w.length];
            table[0] = w[0];
            for(int i=1;i<w.length;i++){
                table[i] = table[i-1]+w[i];
            }
            this.MAX = table[table.length-1];
        }

        public int pickIndex() {
            long r = (long) (Math.random()*MAX) + 1;
            int s=0,e=table.length-1;
            while(s<=e){
                int mid= (s+e)/2;
                if(table[mid]<r){
                    s = mid+1;
                }else if(table[mid]>r){
                    e = mid-1;
                }else{
                    return mid;
                }
            }
            return s;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
