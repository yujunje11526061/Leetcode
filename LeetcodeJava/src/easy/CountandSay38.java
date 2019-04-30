package easy;

public class CountandSay38 {
    public static CountandSay38 instance = new CountandSay38();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.countAndSay(5));
    }

    class Solution {
        public String countAndSay(int n) {
            String string = "1";
            for(int i=1;i<n;i++){
                StringBuilder stringBuilder = new StringBuilder();
                int cnt = 0;
                char pre = ' ';
                for(int j=0;j<string.length();j++){
                    char x = string.charAt(j);
                    if(pre==' '|| pre==x){
                        cnt++;
                    }else{
                        stringBuilder.append(cnt+"").append(pre);
                        cnt = 1;
                    }
                    pre = x;
                }
                stringBuilder.append(cnt).append(pre);
                string = stringBuilder.toString();
            }
            return string;
        }
    }
}
