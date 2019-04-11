package medium;

public class UniqueBinarySearchTrees96 {
    public static UniqueBinarySearchTrees96 instance = new UniqueBinarySearchTrees96();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int n = 3;
        int result = instance.solution.numTrees(n);
        System.out.println(result);
    }

    class Solution {
        public int numTrees(int n) {
            int[] table = new int[n+1];
            table[0] = 1;
            for(int i=1;i<n+1;i++){
                int sum = 0;
                for(int j=0;j<i/2;j++){
                    sum += table[j]*table[i-j-1];
                }
                sum *=2;
                if((i&1)==1){
                    sum += table[i/2]*table[i/2];
                }
                table[i] = sum;
            }
            return table[n];
        }
    }
}
