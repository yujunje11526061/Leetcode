package easy;

import java.util.*;

public class FindCommonCharacters1002 {
    public static FindCommonCharacters1002 instance = new FindCommonCharacters1002();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        System.out.println(instance.solution.commonChars(A));
    }

    class Solution {
//        public List<String> commonChars1(String[] A) {
//            List<HashMap<Character, Integer>> list = new ArrayList<>();
//            for(String string: A){
//                HashMap<Character, Integer> hashMap = new HashMap<>();
//                for(int i=0;i<string.length();i++){
//                    char c = string.charAt(i);
//                    hashMap.merge(c,1,Integer::sum);
//                }
//                list.add(hashMap);
//            }
//            Set<Character> ss = list.get(0).keySet();
//            for(HashMap<Character, Integer> hashMap:list){
//                Set<Character> set = hashMap.keySet();
//                ss.retainAll(set);
//            }
//            List<String> list1 = new ArrayList<>();
//            for(Character c : ss){
//                int cnt = 0x7fffffff;
//                for(HashMap<Character, Integer> hashMap:list){
//                    int v = hashMap.get(c);
//                    cnt = cnt<v?cnt:v;
//                }
//                for(int i=0;i<cnt;i++){
//                    list1.add(c.toString());
//                }
//            }
//            return list1;
//        }

        public List<String> commonChars(String[] A) {
            int[] table = new int[26];
            for(int i=0;i<table.length;i++){
                table[i] = 0x7fffffff;
            }
            for(String string: A){
                int[] tmp = new int[26];
                for(int i=0;i<string.length();i++){
                    char c = string.charAt(i);
                    tmp[c-'a'] += 1;
                }
                for(int i=0;i<26;i++){
                    table[i] = table[i]<tmp[i]?table[i]:tmp[i];
                }
            }
            List<String> list = new ArrayList<>();
            for(int i=0;i<table.length;i++){
                if(table[i]>0){
                    char c = (char)(i+'a');
                    for(int j=0;j<table[i];j++){
                        list.add(c+"");
                    }
                }
            }
            return list;
        }
    }
}
