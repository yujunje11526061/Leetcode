package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_II119 {
    public static PascalsTriangle_II119 instance = new PascalsTriangle_II119();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.getRow(3));
    }

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if(rowIndex<0){
                return new ArrayList<Integer>();
            }
            List<Integer> table = new ArrayList<>(rowIndex+1);
            for(int i=0;i<=rowIndex;i++){
                table.add(1);
                for(int j=i-1;j>0;j--){
                    table.set(j,table.get(j)+table.get(j-1));
                }
            }
            return table;
        }
    }
}
