package hard;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderlyQueue899 {
    public static OrderlyQueue899 instance = new OrderlyQueue899();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String S = "cba";
        int K = 1;
        System.out.println(instance.solution.orderlyQueue(S,K));
    }

    class Solution {
        public String orderlyQueue(String S, int K) {
            if(K==0){
                return S;
            }
            if(K>1){
                char[] al = S.toCharArray();
                Arrays.sort(al);
                return new String(al);
            }else{
                char minC = 'z';
                ArrayList<Integer> note = new ArrayList<>();
                for(int i=0;i<S.length();i++){
                    if(S.charAt(i)<minC){
                        note.clear();
                        note.add(i);
                        minC = S.charAt(i);
                    }else if(S.charAt(i)==minC){
                        note.add(i);
                    }
                }
                if(note.size()==S.length()){
                    return S;
                }
                ArrayList<String> stringStartWithMinC = new ArrayList<>();
                for(int i:note){
                    StringBuilder sb = new StringBuilder();
                    sb.append(S.substring(i));
                    sb.append(S.substring(0,i));
                    stringStartWithMinC.add(sb.toString());
                }
                String minString = "zzzzzzzzzzzzzzzzzzzzzzzz";
                for(String s:stringStartWithMinC){
                    if(s.compareTo(minString)<0){
                        minString=s;
                    }
                }
                return minString;
            }
        }
    }
}
