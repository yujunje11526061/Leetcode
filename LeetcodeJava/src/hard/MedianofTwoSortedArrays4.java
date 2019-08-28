package hard;

public class MedianofTwoSortedArrays4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 记i和j分别为在两个数组中后半段的起始坐标,也是各自在前半段的长度，超过长度代表此数组全在前半段
            // 总数为奇数时，中位数看成在前半段
            // 因为 i+j = m+n-i-j或者 i+j = m+n-i-j+1， 所以j=(m+n+1)/2-i
            // 为了保证j不为负数，则应该使得 i<=min(m,n), 可以交换引用使得nums1为短的数组
            // m = nums1.length, n=nums2.length
            // i在[0，m]中取，则由不等式关系可以推导出 0<=j<=n
            // 由于j受到i的制约，所以对任意i，得到的j都能保证左右总长一样或左边大1.
            // 要找中位数，则需满足，nums1[i-1]<=nums2[j] && nums1[i]>=nums[j-1]
            // if(nums1[i-1]>nums2[j]),说明i太大，if(nums1[i]<nums2[j-1]),说明i太小
            // 对i进行二分，j会相应着变
            // 结束时，若m+n为奇数，则中位数为 max(nums1[i-1], nums2[j-1]),
            // 否则为 max(nums1[i-1], nums2[j-1])+min(nums1[i], nums2[j])

            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int m = nums1.length, n = nums2.length;
            int s = 0, e = m, i = (s+e)/2, j=(m+n+1)/2 -i;
            while (s <= m) {
                i = (s+e)/2;
                j = (m+n+1)/2 -i;
                if(i<m && nums2[j-1]>nums1[i]){
                    // j=(m+n+1)/2-i > (m+n+1)/2-m > (m+m+1)/2-m >= 0，j>0不会越界
                    s = i+1;
                }else if(i>0 && nums1[i-1]>nums2[j]){
                    // j=(m+n+1)/2-i < (m+n+1)/2 < (n+n+1)/2 <= n, j<n不会越界
                    e = i-1;
                }else{
                    break;
                }
            }
            int maxLeft = 0;
            // i和j必然不会同时为0
            if (i == 0) { maxLeft = nums2[j-1]; }
            else if (j == 0) { maxLeft = nums1[i-1]; }
            else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
            if ( ((m + n) & 1) == 1 ) { return maxLeft; }

            int minRight = 0;
            // i和j必然不会同时在两数组的右边界之外
            if (i == m) { minRight = nums2[j]; }
            else if (j == n) { minRight = nums1[i]; }
            else { minRight = Math.min(nums2[j], nums1[i]); }
            return (minRight+maxLeft)/2.0;
        }
    }
}
