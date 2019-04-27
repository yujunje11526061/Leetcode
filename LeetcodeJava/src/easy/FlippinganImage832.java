package easy;

import java.util.Arrays;

public class FlippinganImage832 {
    public static FlippinganImage832 instance = new FlippinganImage832();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] A =  {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(Arrays.deepToString(instance.solution.flipAndInvertImage(A)));
    }
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            if(A==null){
                return null;
            }
            for(int[] a:A){
                int i=0,j=a.length-1;
                for(;i<j;i++,j--){
                    if(a[i]==a[j]){
                        a[i] = a[j] = Math.abs(a[i]-1);
                    }
                }
                if(i==j){
                    a[i]= Math.abs(a[i]-1);
                }
            }
            return A;
        }
    }
}
