package medium;

public class ShiftingLetters848 {
    public static ShiftingLetters848 instance = new ShiftingLetters848();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s="abc";
        int[] shifts = {3,5,9};
        System.out.println(instance.solution.shiftingLetters(s,shifts));
    }

    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            shifts[shifts.length-1] %= 26;
            for(int i=shifts.length-2;i>=0;i--){
                shifts[i] = (shifts[i+1]+shifts[i])%26;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<S.length();i++){
                char c = change(S.charAt(i),shifts[i]);
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }

        private char change(char pre, int t) {
            if('z'-pre>=t){
                return (char) (t+pre);
            }else{
                return (char) (pre+t-'z'+'a'-1);
            }
        }
    }
}
