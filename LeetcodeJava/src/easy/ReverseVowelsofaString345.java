package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString345 {
    public static ReverseVowelsofaString345 instance = new ReverseVowelsofaString345();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String s = " ";
        String result = instance.solution.reverseVowels(s);
        System.out.println(result);
    }
    class Solution {
        public String reverseVowels(String s) {
            if(s==null ||s.length()==0){
                return "";
            }
            int i=0,j = s.length()-1;
            HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
            char[] string = new char[j+1];
            while(i<=j){
                while(i<j && !set.contains(s.charAt(i))){
                    string[i] = s.charAt(i);
                    i++;
                }
                while(j>i && !set.contains(s.charAt(j))){
                    string[j] = s.charAt(j);
                    j--;
                }
                if(i<=j) {
                    string[i] = s.charAt(j);
                    string[j] = s.charAt(i);
                    i++;
                    j--;
                }
            }
            return new String(string);
        }
    }
}
