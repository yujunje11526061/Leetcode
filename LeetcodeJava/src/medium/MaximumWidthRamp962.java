package medium;

public class MaximumWidthRamp962 {
    public static MaximumWidthRamp962 instance= new MaximumWidthRamp962();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A =  {6,0,8,2,1,5};
        int[] A2 = {9,8,1,0,1,9,4,0,4,1};
        int[] A3 = {0,1};
        System.out.println(instance.solution.maxWidthRamp(A3));
    }


    class Solution {
        public int maxWidthRamp(int[] A) {
            int result=0;
            if(A==null || A.length<=1){
                return result;
            }
            result = strategy1(A);
//            System.out.println(result);
//            result = strategy2(A);
            return result;
        }

        // 该方法遇到最坏情况O(N^2)超时
        private int strategy1(int[] a) {
            int x=0,y=0;
            for(int i=0;i<a.length;i++) {
                if(a[i]>=a[x]&&y>x){
                    continue;
                }
                for (int j = a.length - 1; j > y+i-x; j--){
                    if(a[i]<=a[j]){
                        x=i;
                        y=j;
                    }
                }
            }
            return y-x;
        }

        // 一个辅助数组leftMin记录到当前为止左边的最小值，则该数组非增
        // 一个辅助数组leftMinIndex记录到当前为止左边的最小值在原数组中的坐标，则该数组非减
        // 扫描原数组，对每一个i，在[0，i-1]坐标区间二分搜索leftMin，找到尽可能左边的比A[i]小的数，然后通过查leftMinIndex数组可以知道该最左坐标是多少
        // 时间复杂度O(NlogN)，空间开销两个额外数组。
        private int strategy2(int[] a) {
            int[] leftMin = new int[a.length];
            int[] leftMinIndex = new int[a.length];
            leftMin[0] = a[0];
            leftMinIndex[0] = 0;
            int width = 0;
            for(int i=1;i<a.length;i++){
                if(a[i]<leftMin[i-1]){
                    leftMin[i]=a[i];
                    leftMinIndex[i] = i;
                }else {
                    leftMin[i] = leftMin[i-1];
                    leftMinIndex[i] = leftMinIndex[i-1];
                    int s = 0, e = i - 1;
                    while (s <= e) {
                        int mid = (e + s) / 2;
                        if (leftMin[mid] <= a[i]) {
                            e = mid - 1;
                        } else {
                            s = mid + 1;
                        }
                    }
                    width = i - leftMinIndex[s] > width ? i - leftMinIndex[s] : width;
                }
            }

            return width;
        }

        // 思路三，把 (数组值，索引) 元组递增排序，则双指针从左往右扫描一次，碰到索引更小的，则更新左指针，找到最大索引差即可
        // 时间复杂度主要在于排序
    }
}
