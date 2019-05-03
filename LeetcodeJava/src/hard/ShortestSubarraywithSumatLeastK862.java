package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithSumatLeastK862 {
    public static ShortestSubarraywithSumatLeastK862 instance = new ShortestSubarraywithSumatLeastK862();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {84, -37, 32, 40, 95};
        int K = 167;
        System.out.println(instance.solution.shortestSubarray(A, K));
    }

    class Solution {
        public int shortestSubarray(int[] A, int K) {
            int minLength = 0x7fffffff;
            int length = 0;
            int sum = 0;
            // 双指针法，i为前边界，j为后边界
            int i = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] >= K) {
                    return 1;
                }
                sum += A[j];
                length++;
                // K为正数，故可以舍弃前面的和为负的段，重置状态，从下一处开始扫描。
                if (sum <= 0) {
                    i = j + 1;
                    length = 0;
                    sum = 0;
                    continue;
                }
                // 以下for循环很关键，因为和为正数的某段中可能有负数捣乱。故需要转化为只有正数和0的等效序列。
                // 像以上示例的情况，如果直接走后面的while循环紧缩前边界i，84似乎不能被去掉，但由于-37削弱了84的作用，实际上84可以可以和37一起去掉。
                // 故对于正数段中的负数，通过前向迭加，去掉负数（因为是和为正数的段，最终必然能在不越过前边界i之前去掉所有负数），化作同等和的正数与0序列。
                // 相当于把负数的隐藏效果显露到左边，靠近左边界，从而以下while循环中才可以透过假象，实打实地紧缩前边界。
                // 如此例84，-37变成47，0，这样47能被去掉，0自然也紧接着被去掉，与直接去掉84和-37是等效的。
                for (int p = j - 1; A[p + 1] < 0; p--) {
                    A[p] = A[p] + A[p + 1]; // 将负数与左边的数相加，综合效果保存在左边，自己置零
                    A[p + 1] = 0;
                }
                if (sum >= K) {
                    // 看看是否可以紧缩前边界
                    while (sum >= K) {
                        sum -= A[i];
                        i++;
                    }
                    length = Math.min(length, j - i + 2);
                    minLength = Math.min(minLength, length);
                }
            }
            if (minLength == 0x7fffffff) {
                return -1;
            }
            return minLength;
        }
    }

    class Solution2 {
        public int shortestSubarray2(int[] A, int K) {
            int N = A.length, res = N + 1;
            int[] B = new int[N + 1];
            // 得到累计和，转化为差B[e]-B[s]>=K的最小坐标差e-s
            for (int i = 0; i < N; i++){
                B[i + 1] = B[i] + A[i];
            }
            // 本质还是双指针法，只是基于双端队列来操作。而双指针，马上就应该想到递增的前提
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < N + 1; i++) {
                // 紧缩前边界
                while (deque.size() > 0 && B[i] - B[deque.getFirst()] >= K) {
                    res = Math.min(res, i - deque.pollFirst());
                }
                // 这一步很关键，保证队列中元素是符合递增意义的（此处为累计和递增）
                // 这样才能保证在右移右边界后，上一个while循环中计算的段内和是正数，且可以实打实地紧缩前边界，否则队列头出队又会被妨碍，掩盖后面段内和更大且长度更短的数字段。
                while (deque.size() > 0 && B[i] <= B[deque.getLast()]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            return res <= N ? res : -1;
        }
    }
}
