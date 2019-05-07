package medium;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates816 {
    public static AmbiguousCoordinates816 instance = new AmbiguousCoordinates816();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String S = "(01230)";
        System.out.println(instance.solution.ambiguousCoordinates(S));
    }

    class Solution {
        public List<String> ambiguousCoordinates(String S) {
            List<String> list = new ArrayList<>();
            if(S==null || S.length()<4){
                return list;
            }
//            S = S.substring(1,S.length()-1);
            String template = "(%s, %s)";
            for(int i=1;i<S.length();i++){
                for(int j=1;j<=i;j++){
                    String head;
                    if(j==i){
                        head = S.substring(1,j+1);
                    }else {
                        head = S.substring(1, j + 1) + "." + S.substring(j + 1, i + 1);
                    }
                    if(!isResonable(head)){
                        continue;
                    }
                    for(int k=i+1;k<S.length()-1;k++){
                        String tail;
                        if(k+1==S.length()-1){
                            tail = S.substring(i+1,k+1);
                        }else {
                            tail=S.substring(i + 1, k + 1) + "." + S.substring(k + 1, S.length() - 1);
                        }
                        if(isResonable(tail)){
                            String re = String.format(template, head, tail);
                            list.add(re);
                        }
                    }
                }
            }
            return list;
        }

        private boolean isResonable(String s) {
            if(s.startsWith("0")&&s.length()>1&&s.charAt(1)!='.'){
                return false;
            }
            if(s.endsWith("0")&&s.indexOf(".")!=-1){
                return false;
            }
            return true;
        }
    }
}
