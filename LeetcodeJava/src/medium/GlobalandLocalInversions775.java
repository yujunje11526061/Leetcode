package medium;

public class GlobalandLocalInversions775 {
    public static GlobalandLocalInversions775 instance = new GlobalandLocalInversions775();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] A = {1,2,0};
        System.out.println(instance.solution.isIdealPermutation(A));
    }


    class Solution {
        public boolean isIdealPermutation(int[] A) {
            for(int i=0;i<A.length;i++){
                if(Math.abs(i-A[i])>=2){
                    return false;
                }
            }
            return true;
        }
    }
}
