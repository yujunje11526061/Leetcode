package easy;

import java.util.ArrayList;
import java.util.HashSet;

public class BuddyStrings859 {
    public static BuddyStrings859 instance = new BuddyStrings859();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.buddyStrings("ab","ab"));
    }

    class Solution {
        public boolean buddyStrings(String A, String B) {
            if(A.length()!=B.length()){
                return false;
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            HashSet<Character> hashSet = new HashSet<>();
            for(int i=0; i<A.length();i++){
                if(A.charAt(i)!=B.charAt(i)){
                    arrayList.add(i);
                }
                hashSet.add(A.charAt(i));
            }
            if(arrayList.size()==0) {
                return hashSet.size()==A.length()?false:true;
            }
            if(arrayList.size()!=2){
                return false;
            }else {
                int x = arrayList.get(0);
                int y = arrayList.get(1);
                if(A.charAt(x)==B.charAt(y) && B.charAt(x)==A.charAt(y)){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
