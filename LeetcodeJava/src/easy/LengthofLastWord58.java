package easy;

public class LengthofLastWord58 {
    public static LengthofLastWord58 instance = new LengthofLastWord58();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.lengthOfLastWord("a"));
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            if(s.length()==0){
                return 0;
            }
            int end=s.length()-1;
            int start = end;
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)==' '){
                    if(i<end){
                        start=i+1;
                        break;
                    }else {
                        end--;
                    }
                }
                else {
                    start = i;
                }
            }
            if(start>end){
                return 0;
            }
            return end-start+1;
        }
    }
}
