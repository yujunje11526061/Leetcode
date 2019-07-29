package medium;

public class GasStation134 {
    public static GasStation134 instance = new GasStation134();
    public Solution solution  = new Solution();

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(instance.solution.canCompleteCircuit(gas,cost));
    }

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int[] val = new int[gas.length];
            int sum = 0;
            for (int i = 0; i <gas.length ; i++) {
                val[i] = gas[i]-cost[i];
                sum += val[i];
            }
            if(sum<0){
                return -1;
            }
            int cnt = 0;
            for (int i = 0; i < val.length;) {
                if(val[i]<0){
                    i++;
                    continue;
                }
                sum = val[i];
                cnt = 1;
                int j = i+1;
                for (; cnt<gas.length; j++,cnt++) {
                    sum += val[j%val.length];
                    if(sum<0){
                        break;
                    }
                }
                if(cnt==gas.length){
                    return i;
                }
                // 当遇到第一个使得累加和为负数的j时,则新的起点可以直接从j+1开始，而不是从i+1开始。
                // 因为对圈内任意i到j之间的k
                // 从val[i]+。+val[k] + 。+val[j]<0；
                // 由于j是第一个出现负数和的点，所以val[i]+。+val[k]>=0；
                // 从而必然有val[k+1]+。。。+val[j]<0，即i到j之间任意点都不可能作为新起点。
                // i=(j+1)%val.length;
                i = j+1;
            }
            return -1;
        }
    }
}
