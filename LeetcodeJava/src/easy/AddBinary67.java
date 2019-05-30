package easy;

import java.util.ArrayList;
import java.util.List;

public class AddBinary67 {
    public static AddBinary67 instance = new AddBinary67();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.addBinary("1110","1111"));
    }

    class Solution {
        public String addBinary(String a, String b) {
            List<Character> list = new ArrayList<>();
            int i = a.length()-1, j = b.length()-1;
            char x = '0';
            while(i>=0 && j>=0){
                int cnt=0;
                if(a.charAt(i)=='1'){cnt++;}
                if(b.charAt(j)=='1'){cnt++;}
                if(x=='1'){cnt++;}

                x = cnt>1?'1':'0';

                if(cnt==0||cnt==2){
                    list.add('0');
                }else{
                    list.add('1');
                }
                i--;
                j--;
            }
            while(i>=0){
                int cnt=0;
                if(a.charAt(i)=='1'){cnt++;}
                if(x=='1'){cnt++;}
                x = cnt>1?'1':'0';
                if(cnt==0||cnt==2){
                    list.add('0');
                }else{
                    list.add('1');
                }
                i--;
            }
            while(j>=0){
                int cnt=0;
                if(b.charAt(j)=='1'){cnt++;}
                if(x=='1'){cnt++;}

                x = cnt>1?'1':'0';

                if(cnt==0||cnt==2){
                    list.add('0');
                }else{
                    list.add('1');
                }
                j--;
            }
            if(x=='1'){
                list.add(x);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int k=list.size()-1;k>=0;k--){
                stringBuilder.append(list.get(k));
            }
            return stringBuilder.toString();
        }
    }
}
