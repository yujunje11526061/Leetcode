package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount811 {
    public static SubdomainVisitCount811 instance = new SubdomainVisitCount811();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(instance.solution.subdomainVisits(cpdomains));
    }
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(String s:cpdomains){
                String[] sl = s.split(" ");
                int cnt = Integer.valueOf(sl[0]);
//                String[] sx = sl[1].split("\\.");
//                String tmp = sx[sx.length-1];
//                hashMap.merge(tmp,cnt,Integer::sum);
//                for(int i= sx.length-2;i>=0;i--){
//                    String sp = sx[i];
//                    tmp = sp+"."+tmp;
//                    hashMap.merge(tmp,cnt,Integer::sum);
//                }
                hashMap.merge(sl[1], cnt, Integer::sum);
                for(int i=0;i<sl[1].length();i++){
                    if(sl[1].charAt(i)=='.'){
                        hashMap.merge(sl[1].substring(i+1), cnt, Integer::sum);
                    }
                }
            }
            List<String> result = new ArrayList<>();
            hashMap.forEach((k,v)->{
                String rs = String.valueOf(v)+" "+k;
                result.add(rs);
            });
            return result;
        }
    }
}
