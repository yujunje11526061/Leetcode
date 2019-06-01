package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static PascalsTriangle118 instance = new PascalsTriangle118();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.generate(5));
    }

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> pre = null;
            for(int i=0;i<numRows;i++){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                if(pre!=null){
                    for(int j=1;j<pre.size();j++){
                        list.add(pre.get(j)+pre.get(j-1));
                    }
                }
                if(!result.isEmpty()) {
                    list.add(1);
                }
                pre = list;
                result.add(list);
            }
            return result;
        }
    }
}
