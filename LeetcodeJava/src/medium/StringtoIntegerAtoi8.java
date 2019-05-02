package medium;

public class StringtoIntegerAtoi8 {
    public static StringtoIntegerAtoi8 instance = new StringtoIntegerAtoi8();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] A = {"-2147483648","00000000000000000000000002", "20000000000000000000000000000","     -45", "434 rewrw rsdff", "fsdafsa f asd 65", "-123412354364","   "};
        for (String s : A) {
            System.out.println(instance.solution.myAtoi(s));
        }
    }

    class Solution {
        public int myAtoi(String str) {
            StringBuilder result = new StringBuilder();
//            str = str.strip();
            boolean hasdigit = false;
            boolean signal = false;
            boolean allZero = false;
            int start=0;
            for(;start<str.length();start++){
                char c = str.charAt(start);
                if(c!=' '){
                    break;
                }
            }
            for (int i = start; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '+' || c == '-') {
                    if (signal && !hasdigit) {
                        return 0;
                    } else if (hasdigit) {
                        break;
                    } else {
                        signal = true;
                        result.append(c);
                    }
                } else if (Character.isDigit(c)) {
                    hasdigit = true;
//                    if(allZero && c=='0'){
//                        continue;
//                    }else if(allZero && c!='0'){
//                        allZero = false;
//                    }
                    result.append(c);
                }else{
                    if(hasdigit){
                        break;
                    }else{
                        return 0;
                    }
                }
            }
            String resultString = result.toString();
            if(resultString.length()==0){
                return 0;
            }
            int len = resultString.length();
            if(resultString.charAt(0)=='-'|| resultString.charAt(0)=='+'){
                len--;
            }
            if(len==0) {
                return 0;
            }
//            else if(len>10){
//                return 0x80000000;
//            }
            else{
                long r = 0;
                int up = 0x7fffffff;
                int down = 0x80000000;
                int begin = 1;
                if(Character.isDigit(resultString.charAt(0))){
                    begin--;
                }
                for(int i=begin;i<resultString.length();i++){
                    int x = resultString.charAt(i)-'0';
                    r = r*10+x;
                    if(resultString.charAt(0)=='-' && -r<down){
                        return down;
                    }
                    else if(resultString.charAt(0)!='-' && r>up){
                        return up;
                    }
                }
                if(resultString.charAt(0)=='-'){
                    r = -r;
                }
                return (int)r;
            }
        }
    }
}
