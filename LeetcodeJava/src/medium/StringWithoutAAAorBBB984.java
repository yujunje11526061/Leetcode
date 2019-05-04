package medium;

public class StringWithoutAAAorBBB984 {
    public static StringWithoutAAAorBBB984 instance = new StringWithoutAAAorBBB984();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.strWithout3a3b(5,8));
    }

    class Solution {
        public String strWithout3a3b(int A, int B) {
            char base= 'a';
            char iso = 'b';
            int numBase = A;
            int numIso = B;
            if(A<B){
                base = 'b';
                iso = 'a';
                numBase = B;
                numIso = A;
            }
//            one + two = numIso
//            one + 2*two = numBase - [0|1|2]
            int two, one, offset=0;
            one = 2*numIso-numBase;
            while(one<0){
                one++;
                offset++;
            }
            two = numIso-one;
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<offset;i++){
                stringBuilder.append(base);
            }
            String forOne = iso+""+base;
            String forTwo = iso+""+base+""+base;
            for(int i=0;i<one;i++){
                stringBuilder.append(forOne);
            }
            for(int i=0;i<two;i++){
                stringBuilder.append(forTwo);
            }
            return stringBuilder.toString();
        }
    }
}
