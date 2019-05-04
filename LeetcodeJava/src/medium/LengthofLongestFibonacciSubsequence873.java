package medium;

import java.util.HashMap;

public class LengthofLongestFibonacciSubsequence873 {
    public static LengthofLongestFibonacciSubsequence873 instance = new LengthofLongestFibonacciSubsequence873();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(instance.solution.lenLongestFibSubseq(A));
    }

    class Solution {
        int maxLen = 2;
        // 记录某个值的位置，这样在找是否有下一个数时不用后向遍历，直接查映射表就能知道位置。严格递增，故不用担心重复
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        public int lenLongestFibSubseq(int[] A) {
            for (int i = 0; i < A.length; i++) {
                hashMap.put(A[i], i);
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
//                  if (A.length - 1 - j + 2 <= maxLen) {
                    if (A.length + 1 - j <= maxLen) {
                        break;
                    }
                    find(i, j, A, 2);
                }
            }
            return maxLen > 2 ? maxLen : 0;
        }

        private void find(int i, int j, int[] A, int len) {
            int need = A[i] + A[j];
//            for (int k = j + 1; k < A.length; k++) {
//                if (A[k] > need) {
//                    maxLen = Math.max(maxLen, len);
//                    return;
//                } else if (A[k] == need) {
//                    find(j, k, A, len + 1);
//                    return;
//                }
//            }
            int next=hashMap.getOrDefault(need,-1);
            if(next==-1) {
                maxLen = Math.max(maxLen, len);
            }else{
                find(j,next,A,len+1);
            }
        }
    }
}
