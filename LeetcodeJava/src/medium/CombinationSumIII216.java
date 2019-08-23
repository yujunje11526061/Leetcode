package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {

    public static CombinationSumIII216 instance = new CombinationSumIII216();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.combinationSum3(3,9));
    }

    class Solution {
        private List<List<Integer>> list = new ArrayList<>();
        private List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            if((19-k)*k/2<n || (1+k)*k/2>n){
                return new ArrayList<>();
            }
            for (int i = 1; i < 10; i++) {
                search(i,n,k);
            }
            return list;
        }

        private void search(int i, int n, int k) {
            if(i>n){
                return;
            }
            temp.add(i);
            n = n-i;
            k--;
            if(n==0&& k==0){
                list.add(new ArrayList<>(temp));
            }else if(n!=0&&k!=0) {
                for (int j = i + 1; j < 10; j++) {
                    search(j, n , k );
                }
            }
            temp.remove(temp.size()-1);
        }
    }
}
