package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
回溯剪枝。
 */
public class BinaryWatch401 {
    public static BinaryWatch401 instance = new BinaryWatch401();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] s = {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
        List<String> result = instance.solution.readBinaryWatch(2);
        List<String> aa = Arrays.asList(s);;
        result.sort(((o1, o2) -> o1.compareTo(o2)));
        aa.sort(((o1, o2) -> o1.compareTo(o2)));

        System.out.println(result);
        System.out.println(aa);
    }

    class Solution {
        List<String> list= new ArrayList<>();
        int[] table = {1,2,4,8,1,2,4,8,16,32};
        public List<String> readBinaryWatch(int num) {
            if(num>=table.length-1){
                return list;
            }
            find(0,0,num,0);
            return list;
        }

        private void changeFormatAndInsert(int h, int m){
            list.add(String.format("%d:%02d",h,m));
        }

        private void find(int h,int m,int cnt, int loc){
            if(cnt==0){
                changeFormatAndInsert(h,m);
                return;
            }
            for(int i=loc;i<table.length;i++){
                int nh =h;
                int nm = m;
                if(cnt>=7&&i==3){
                    break;
                }
                if(i<4){
                    nh = h+table[i];
                }else{
                    nm = m+table[i];
                }
                if(nh>11||nm>59){
                    continue;
                }
                find(nh,nm,cnt-1,i+1);
            }
        }
    }
}
