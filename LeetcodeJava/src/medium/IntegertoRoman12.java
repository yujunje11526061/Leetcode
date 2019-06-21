package medium;

import java.util.HashMap;
import java.util.Map;

public class IntegertoRoman12 {
    public static IntegertoRoman12 instance = new IntegertoRoman12();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.intToRoman(40));
    }

    class Solution {
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            Map<Integer, Character> map = new HashMap<>();
            map.put(1,'I');
            map.put(5,'V');
            map.put(10,'X');
            map.put(50,'L');
            map.put(100,'C');
            map.put(500,'D');
            map.put(1000,'M');
            int n;
            int d = 1000;
            while(num>0){
                n = num/d;
                Character c;
                if(n==4){
                    sb.append(map.get(d));
                    c = map.get((n+1)*d);
                    sb.append(c);
                }else if(n==9){
                    sb.append(map.get(d));
                    sb.append(map.get(d*10));
                }else if(n>=5){
                    sb.append(map.get(5*d));
                    int left = n%5;
                    c = map.get(d);
                    for (int i = 0; i < left; i++) {
                        sb.append(c);
                    }
                }else {
                    c = map.get(d);
                    for (int i = 0; i < n; i++) {
                        sb.append(c);
                    }
                }
                num = num%d;
                d /= 10;
            }
            return sb.toString();
        }
    }
}
