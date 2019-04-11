package easy;

import java.util.Arrays;

public class TwoSum_II167 {
    public static TwoSum_II167 instance = new TwoSum_II167();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] numbers = {2, 3, 7, 11, 15};
        int target = 9;
        int[] result = instance.solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if (numbers.length <= 1) {
                return null;
            }
            int i = 0, j = numbers.length-1;
            int[] result = new int[2];
            while (i<j) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                } else if (numbers[i] + numbers[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return result;
        }
    }
}
