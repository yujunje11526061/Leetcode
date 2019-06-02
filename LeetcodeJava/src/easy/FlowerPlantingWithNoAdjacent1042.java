package easy;

import java.util.*;

public class FlowerPlantingWithNoAdjacent1042 {
    public static FlowerPlantingWithNoAdjacent1042 instance = new FlowerPlantingWithNoAdjacent1042();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int N =4;
        int[][] paths = {{1,2},{3,4}};
        System.out.println(Arrays.toString(instance.solution.gardenNoAdj(N,paths)));
    }
    class Solution {
        HashSet<Integer> hashSet = new HashSet<>();
        private  int[] result;
        List<Integer>[]  table;
        public int[] gardenNoAdj(int N, int[][] paths) {

            result = new int[N];
            table = new ArrayList[N];
            for(int i=0;i<table.length;i++){
                table[i] = new ArrayList<>();
            }
            for(int[] pair:paths){
                int a = pair[0]-1;
                int b = pair[1]-1;
                table[a].add(b);
                table[b].add(a);
            }

//            for(int i=0;i<N;i++){
//                hashSet.add(i);
//            }
//            while(!hashSet.isEmpty()) {
//                int p = hashSet.iterator().next();
//                dfs(p);
//            }

            // 对于每个点，剔除他邻接点已经拥有的颜色，最后随便染一个剩下的颜色即可
            for(int i=0;i<N;i++){
                Set<Integer> color = new HashSet<>(Arrays.asList(1,2,3,4));
                for(int neighbor:table[i]){
                    color.remove(result[neighbor]);
                }
                result[i] = color.iterator().next();
            }
            return result;
        }

        private void dfs(int p) {
            for(int i=1;i<=4;i++){
                boolean flag = true;
                for(int neighbor:table[p]){
                    if(result[neighbor]==i){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    result[p] = i;
                    hashSet.remove(p);
                    break;
                }
            }
            for(int neighbor:table[p]){
                if(result[neighbor]==0){
                    dfs(neighbor);
                }
            }
        }
    }
}
