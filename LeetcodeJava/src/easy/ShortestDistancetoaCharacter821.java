package easy;

import java.util.Arrays;

public class ShortestDistancetoaCharacter821 {
    public static ShortestDistancetoaCharacter821 instance =new ShortestDistancetoaCharacter821();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        System.out.println(Arrays.toString(instance.solution.shortestToChar(S,C)));
    }
    class Solution {
        public int[] shortestToChar(String S, char C) {
            if(S==null){
                return null;
            }
            int[] result = new int[S.length()];
            for(int i=0;i<S.length();i++){
                result[i] = S.charAt(i)==C?0:100001;
            }
            for(int i=1;i<S.length();i++){

                result[i] = result[i-1]+1<result[i]?result[i-1]+1:result[i];
            }
            for(int i=S.length()-2;i>=0;i--){
                result[i] = result[i+1]+1<result[i]?result[i+1]+1:result[i];
            }
            return result;
        }
    }
}
