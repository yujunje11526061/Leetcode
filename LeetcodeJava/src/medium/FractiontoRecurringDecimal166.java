package medium;

import java.util.HashMap;

public class FractiontoRecurringDecimal166 {
    public static FractiontoRecurringDecimal166 instance = new FractiontoRecurringDecimal166();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.fractionToDecimal(-1, 0x80000000));
    }

    class Solution {
        /*
        坑点很多
        1. 负数
        2. 能除尽
        3. 从哪里开始循环，不是余数重复出现，不是商重复出现，而是被除数重复出现！！这是本题关键！
        4. 前面一串0的处理，得用一个flag，出现过非0数后才能去看是否无限循环
         */
        public String fractionToDecimal(int numerator, int denominator) {
            if(numerator==0){
                return "0";
            }
            long nume = numerator;
            long deno = denominator;
            StringBuilder stringBuilder = new StringBuilder();
            if((numerator^denominator)<0){
                stringBuilder.append('-');
            }
            nume = Math.abs(nume);
            deno = Math.abs(deno);
            long x = nume / deno;
            long y = nume % deno;
            stringBuilder.append(String.valueOf(x));
            if (y == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append('.');
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            HashMap<Long, Integer> hashMap = new HashMap();
            int cnt = 0;
            long pre;
            for (; ; cnt++) {
                pre = y;
                y *= 10;
                x = y / deno;
                y = y % deno;
                if (y == 0) {
                    stringBuilder.append(sb).append(x);
                    break;
                } else if (flag&&hashMap.containsKey(pre)) {
                    int p = hashMap.get(pre);
                    String decimal = sb.toString();
                    String a = decimal.substring(0, p);
                    String b = decimal.substring(p);
                    stringBuilder.append(a).append('(').append(b).append(')');
                    break;
                }
                if (x != 0) {
                    flag = true;
                }
                hashMap.put(pre, cnt);

                sb.append(x);
            }
            return stringBuilder.toString();
        }
    }
}
