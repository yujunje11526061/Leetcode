package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString348 {
    public static FindAllAnagramsinaString348 instance = new FindAllAnagramsinaString348();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.findAnagrams("cbaebabacd", "abc"));
    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if(s.length()<p.length()){
                return new ArrayList<Integer>();
            }
            int[] table = new int[26];
            for(int i=0;i<p.length();i++){
                char x = p.charAt(i);
                table[x-'a'] += 1;
            }
            int[] tmp = new int[26];
            for(int i=0;i<p.length();i++){
                char x = s.charAt(i);
                tmp[x-'a'] += 1;
            }
//            System.out.println(Arrays.toString(table));
            int i=0,j=p.length()-1;
            List<Integer> list = new ArrayList<>();
            boolean flag = false;
            if(Arrays.equals(tmp,table)){
                list.add(i);
                flag = true;
            }

            while(j<s.length()-1){
                j++;
                char cj = s.charAt(j);
                char ci = s.charAt(i);
                tmp[ci-'a'] -= 1;
                tmp[cj-'a'] += 1;
                i++;
                if(flag){
                    if(ci==cj){
                        list.add(i);
                    }
                    else{
                        flag = false;
                    }
                }
                else if(Arrays.equals(tmp,table)){
                    list.add(i);
                    flag =true;
                }else{
                    flag = false;
                }
            }
            return list;
        }
    }
}
