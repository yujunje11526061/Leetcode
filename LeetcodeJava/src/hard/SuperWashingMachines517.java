package hard;

public class SuperWashingMachines517 {
    public static SuperWashingMachines517 instance = new SuperWashingMachines517();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] machines = {0,0,10,0,0,0,10,0,0,0};
        System.out.println(instance.solution.findMinMoves(machines));
    }
    class Solution {
        /*
        The logic here is to find the max 'throughput' going from the leftmost washer to the rightmost washer, and the max of the 'GIVE-OUT' washer. The max of these two is the answer. 最大传输量和最大盈余值之间的最大值。

        从左至右考虑，最左边的要想被平衡，必然要通过右边的，故把其差额转嫁给右边（我可以边接受边付出，故好像前面的不足都转移到我身上）。过程中会出现一个绝对值最大的差额，即所需要的最大传输量。
        We want the max/peak of the 'throughput' because for washer(s) from one side, giving/receiving its load to/from washer(s) from the other side, their to-give/to-receive loads accumulate during the transportation, like for [-2 -2 0 1, 3]. (its original nums could be [1, 1, 3, 4, 6]), the leftmost -2 cannot be balanced directly without going through the 2nd -2. So it is the same as [0, -4, 0, 1, 3] or [0, 0, -4, 1, 3]. Only adjacent machines can transfer loads, and potentially balance each other or accumulate to-balance values. Here, 4 is the max absolute to-balance value we found going from left to right, so it is 4.

        一个机器不能同时给，但能同时接受，故对于那些盈余特别多的，其只能一件件消耗，故还得把他和最大传输量取对比。
        Why not Math.abs(load-avg)? Because [-1, 2 ,-1] and [1, -2, 1] are different!! The former can be balanced with 2 steps, but the latter can be balanced with only 1 step! That is to say, giving out loads and receiving loads are different. One machines can at most give 1 load each step, but can receive at most 2 loads each step. Therefore, finding the max positive to-balance load is what we want. Like [0, -7, 8, -1], no matter what you do or how you do it, the machines with 8 loads need no less than 8 to balance itself and become 0.
        */
        public int findMinMoves(int[] machines) {
            int sum = 0;
            for(int n:machines){
                sum += n;
            }
            if(sum%machines.length!=0){
                return -1;
            }
            int avg = sum/machines.length;
            int result = 0;
            int accumulatedDiff = 0;
            boolean given = true;
            for(int x:machines) {
                int diff = x-avg;
                accumulatedDiff += diff;
                result = Math.max(result, Math.abs(accumulatedDiff));
                if(diff>0){
                    result = Math.max(result, diff);
                }
            }
            return result;
        }
    }
}
