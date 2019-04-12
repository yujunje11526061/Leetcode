package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class CarFleet853 {
    public static CarFleet853 instance = new CarFleet853();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(instance.solution.carFleet(target, position, speed));
    }
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            if(position==null||position.length==0){
                return 0;
            }
            ArrayList<int[]> table = new ArrayList<>();
            for(int i=0;i<position.length;i++){
                int[] temp = {position[i], speed[i]};
                table.add(temp);
            }
            table.sort((o1, o2) -> o2[0]-o1[0]);
//            System.out.println(Arrays.deepToString(table.toArray()));
            int prev=0;
            int cnt = 1;
            for(int i=1;i<table.size();i++){
                int[] before = table.get(prev);
                int[] now = table.get(i);
                double t1 = (target-before[0])*1.0/before[1];
                double t2 = (target-now[0])*1.0/now[1];
                if(t1<t2){
                    prev = i;
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
