package medium;

import java.util.Arrays;

public class BagofTokens948 {

    class Solution {
        public int bagOfTokensScore(int[] tokens, int P) {
            Arrays.sort(tokens);
            int i = 0, j = tokens.length - 1;
            int points =0;
            while(i<=j){
                if(tokens[i]<=P){
                    points++;
                    P-= tokens[i];
                    i++;
                }else{
                    if(i<j && points>0){
                        P += tokens[j];
                        points--;
                        j--;
                    }else{
                        break;
                    }
                }
            }
            return points;
        }
    }
}
