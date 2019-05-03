package medium;

import java.math.BigInteger;

public class SmallestIntegerDivisiblebyK1015 {
    public static SmallestIntegerDivisiblebyK1015 instance = new SmallestIntegerDivisiblebyK1015();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.smallestRepunitDivByK(31));
    }

//    Explanation
//
//    For different N, we calculate the remainder of mod K.
//    It has to use the remainder for these two reason:
//
//    Integer overflow
//    The division operation for big integers, is NOT O(1), it's actually depends on the number of digits..
//    Prove
//
//    Why 5 is a corner case? It has a reason and we can find it.
//    Assume that N = 1 to N = K, if there isn't 111...11 % K == 0
//    There are at most K - 1 different remainders: 1, 2, .... K - 1.
//
//    So this is a pigeon holes problem:
//    There must be at least 2 same remainders.
//
//    Assume that,
//    f(N) ≡ f(M), N > M
//    f(N - M) * 10 ^ M ≡ 0
//            10 ^ M ≡ 0, mod K
//    so that K has factor 2 or factor 5.
//
//    Proof by contradiction，
//    If (K % 2 == 0 || K % 5 == 0) return -1;
//    otherwise, there must be a solution N <= K.
//
//    Time Complexity:
//
//    Time O(K), Space O(1)
    class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0 || K % 5 == 0) return -1;
            int r = 0;
            for (int N = 1; N <= K; ++N) {
                // a%b=c
                // (a*10+1)%b=(c*10+1)%b
                // 故每次用余数来算，最终结果和原数对K取余相同，长度可以通过计数来算，避免了越界和使用大整数，大整数运算很慢，取决于长度。
                // 1，3，7，9结尾的数都能凑出末尾为0~9的的任何数，。
                r = (r * 10 + 1) % K;
                if (r == 0) return N;
            }
            return -1;
        }
    }
}
