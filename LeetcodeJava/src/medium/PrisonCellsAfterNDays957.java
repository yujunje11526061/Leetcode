package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays957 {
    public static  PrisonCellsAfterNDays957 instance = new PrisonCellsAfterNDays957();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 1000000000;
        System.out.println(Arrays.toString(instance.solution.prisonAfterNDays(cells,7)));
    }
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Map<Integer,int[]> map = new HashMap<>();
            boolean isLooping = false;
            int headKey = 0;
            for(int i = 1;i <= N;i++){
                int currKey = 0;
                for(int k = 0;k<8;k++)
                    currKey = currKey * 2 + cells[k];
                if(map.containsKey(currKey)){
                    if(!isLooping){
                        isLooping = true;
                        headKey = currKey;
                        N = N - i;
                        i = 0;
                    }else if(currKey == headKey && isLooping){
                        N = (N-i) % (i);
                        i = 0;
                    }
                    cells = map.get(currKey);
                }else{
                    int[] nextCells = new int[cells.length];
                    for(int j = 1;j< 7;j++){
                        if(cells[j-1] == cells[j+1]) nextCells[j] = 1;
                    }
                    map.put(currKey,nextCells);
                    cells = nextCells;
                }
            }
            return cells;
        }
    }
}
