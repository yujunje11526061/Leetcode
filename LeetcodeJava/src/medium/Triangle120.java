package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {
    public static Triangle120 instance = new Triangle120();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3,4);
        List<Integer> list3 = Arrays.asList(6,5,7);
        List<Integer> list4 = Arrays.asList(4,1,8,3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(instance.solution.minimumTotal(lists));
    }

//    自上而下深搜，超时
//    class Solution {
//        private int result=0x7fffffff;
//        private int temp = 0;
//        List<List<Integer>> triangle;
//        public int minimumTotal(List<List<Integer>> triangle) {
//            this.triangle=triangle;
//            find(0,0);
//            return result;
//        }
//
//        private void find(int row, int col) {
//            if(triangle.size()<=row){
//                result = Integer.min(result,temp);
//                return;
//            }
//            temp += triangle.get(row).get(col);
//            find(row+1,col);
//            find(row+1,col+1);
//            temp -= triangle.get(row).get(col);
//        }
//    }

//  自下而上动归
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            List<List<Integer>> result = new ArrayList<>();
//            result.add(triangle.get(triangle.size()-1));
            List<Integer> pre = triangle.get(triangle.size()-1);
            for(int i=triangle.size()-2;i>=0;i--){
                List<Integer> now = new ArrayList<>();
                for(int j=0;j<pre.size()-1;j++){
                    now.add(triangle.get(i).get(j)+Integer.min(pre.get(j), pre.get(j+1)));
                }
//                result.add(now);
                pre = now;
            }
            return pre.get(0);
        }
    }
}
