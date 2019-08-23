package easy;

public class MonotonicArray896 {

    class Solution {
        public boolean isMonotonic(int[] A) {
            if(A==null || A.length==1){
                return true;
            }
            int flag = 0;
            if(A[0]< A[A.length-1]){
                flag = -1;
            }else if(A[0]>A[A.length-1]){
                flag = 1;
            }
            for (int i = 0; i < A.length-1; i++) {
                if(flag==0 && A[i]!=A[i+1]){
                    return false;
                }else if(flag==1 && A[i]<A[i+1]){
                    return false;
                }else if(flag==-1 && A[i]>A[i+1]){
                    return false;
                }
            }
            return true;
        }
    }
}
