package medium;

public class SingleNumberII137 {

    /*
    What we need to do is to store the number of '1's of every bit. Since each of the 32 bits follow the same rules, we just need to consider 1 bit. We know a number appears 3 times at most, so we need 2 bits to store that. Now we have 4 state, 00, 01, 10 and 11, but we only need 3 of them.

    In this solution, 00, 01 and 10 are chosen. Let 'ones' represents the first bit, 'twos' represents the second bit. Then we need to set rules for 'ones' and 'twos' so that they act as we hopes. The complete loop is 00->10->01->00(0->1->2->3/0).


    For 'ones', we can get 'ones = ones ^ A[i]; if (twos == 1) then ones = 0', that can be tansformed to 'ones = (ones ^ A[i]) & ~twos'.


    Similarly, for 'twos', we can get 'twos = twos ^ A[i]; if (ones* == 1) then twos = 0' and 'twos = (twos ^ A[i]) & ~ones'. Notice that 'ones*' is the value of 'ones' after calculation, that is why twos is calculated later.

     */
    class Solution {
        public int singleNumber(int[] nums) {
            int ones=0,twos=0;

            for(int x:nums){
                // ones和twos同时为1即代表是3，此时三进制应该化为0
                // ones和twos只能一个为1，。要么全0.

                // ones的变化好理解，按照上述进制的变化规律即可
                ones = (ones^x)&(~twos);

                // twos为1有两种情况：
                // 1. 原先就是1，x对应为为0，且最新的ones为0，则只能原先ones也为0，否则原先ones和twos同时为1才能是新的ones为0，说明新数对该位没贡献
                // 2. 原先为0，但是x在该位为1，而ones又是0，说明有ones有进位上来了，twos应该记为1
                twos = (twos^x)&(~ones);
            }
            return ones;
        }
    }

    /*

    Here is another example. If a number appears 5 times at most, we can write a program using the same method. Now we need 3 bits and the loop is 000->100->010->110->001. The code looks like this:

        int singleNumber(int A[], int n) {
            int na = 0, nb = 0, nc = 0;
            for(int i = 0; i < n; i++){
                nb = nb ^ (A[i] & na);
                na = (na ^ A[i]) & ~nc;
                nc = nc ^ (A[i] & ~na & ~nb);
            }
            return na & ~nb & ~nc;
        }
     */

}
