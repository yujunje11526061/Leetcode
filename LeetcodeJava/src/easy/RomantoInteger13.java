package easy;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger13 {

    class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);

            char pre = ' ';
            int x = 0;
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(pre=='I' && (c=='V' || c =='X')){
                    x = map.get(c)-map.get(pre)*2;
                    result += x;
                }else if(pre=='X' && (c=='L' || c =='C')){
                    x = map.get(c)-map.get(pre)*2;
                    result += x;
                }else if(pre=='C' && (c=='D' || c =='M')){
                    x = map.get(c)-map.get(pre)*2;
                    result += x;
                }else{
                    x = map.get(c);
                    result += x;
                }
                pre = c;
            }
            return result;
        }
    }
}
