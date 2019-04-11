package easy;

public class RepeatedStringMatch686 {
    public static RepeatedStringMatch686 instance = new RepeatedStringMatch686();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        int result = instance.solution.repeatedStringMatch(A,B);
        System.out.println(result);
    }

    class Solution {
        public int repeatedStringMatch(String A, String B) {
            if(A==null || B==null || A.length()==0){
                return -1;
            }
            if(B.length()==0){
                return 0;
            }
            int minResult = 0x7fffffff;
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)==B.charAt(0)){
                    int result = find(A,B,i);
                    if(result>=0&&result<minResult){
                        minResult=result;
                    }
                }
            }
            return minResult!=0x7fffffff?minResult:-1;
        }
        public int find(String A, String B, int i){
            int count=0;
            int j= i;
            int k=0;
            String A_ = "";
            while(k<B.length()) {
                A_ += A;
                count++;
                for (; j < A_.length() && k < B.length(); j++, k++) {
                    if (A_.charAt(j) != B.charAt(k)) {
                        return -1;
                    }
                }
            }
            return count;
        }
    }
}
