package easy;

import java.util.Arrays;

public class FairCandySwap888 {
    public static FairCandySwap888 instance = new FairCandySwap888();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {2,3};
        System.out.println(Arrays.toString(instance.solution.fairCandySwap(A,B)));
    }

    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int[] result = new int[2];
            Arrays.sort(A);
            Arrays.sort(B);
            int sum=0;
            for(int i:A){
                sum += i;
            }
            int sumA= sum;
            for(int j:B){
                sum += j;
            }
            int sumB = sum-sumA;
            int avg = sum/2;
            for(int a:A){
                int b = a-(sumA-avg);
                if(find(b,B)){
                    result[0] = a;
                    result[1] = b;
                    break;
                }
            }
            return result;
        }

        private boolean find(int b, int[] B) {
            int s=0,e=B.length-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(B[mid]==b){
                    return true;
                }else if(B[mid]<b){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            return false;
        }
    }
}
