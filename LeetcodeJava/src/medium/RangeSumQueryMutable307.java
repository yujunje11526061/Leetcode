package medium;

public class RangeSumQueryMutable307 {
    public static RangeSumQueryMutable307 instance = new RangeSumQueryMutable307();
    public NumArray numArray;

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        instance.numArray = new NumArray(nums);
        System.out.println(instance.numArray.sumRange(0, 2));
        instance.numArray.update(1, 2);
        System.out.println(instance.numArray.sumRange(0, 2));
    }

    static class NumArray {
        int[] nums;
        int[] treeNums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.treeNums = new int[nums.length];
            if(nums.length>0) {  //注意特殊情况检查
                treeNums[0] = nums[0];  // 树状数组虽然从1开始，但是不用变换下标，0是特殊处理的，后面的和原数组下标一致的。
                for (int i = 1; i < treeNums.length; i++) {
                    int diff = nums[i];
                    int j = i;
                    while (j < treeNums.length) {
                        treeNums[j] += diff;
                        j += lowbit(j);
                    }
                }
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public void update(int i, int val) {
            if (i == 0) {
                nums[i] = val;
                treeNums[i] = val;
                return;
            }
            int diff = val - nums[i];
            nums[i] = val;
            while (i < treeNums.length) {
                treeNums[i] += diff;
                i += lowbit(i);
            }
        }

        public int sumRange(int i, int j) {
            if (i == j) {
                return nums[i];
            } else if (i > j) {
                int k = i;
                i = j;
                j = k;
            }
            return getSum(j) - getSum(i)+nums[i];

        }

        private int getSum(int x) {
            int sum = 0;
            while (x > 0) {
                sum += treeNums[x];
                x -= lowbit(x);
            }
            return sum + nums[0];
        }
    }
}
