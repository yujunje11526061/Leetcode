package hard;

import java.util.Arrays;
import java.util.HashSet;

public class PerfectRectangle391 {
    public static PerfectRectangle391 instance = new PerfectRectangle391();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] rectangles = {
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {2, 2, 4, 4},
                {1, 3, 2, 4}
        };
        int[][] rr = {{0,0,4,1},{0,0,4,1}};
        boolean result = instance.solution.isRectangleCover(rectangles);
        System.out.println(result);
    }


// 方法二：并不将所有大矩形中的点进行标记，而是从放入的小矩形入手，将矩形两点表示修改为四点表示。
// 每次访问一个小矩形都尝试将其四个顶点放入set，如果某个点之前set就存在，那么移除，否则放入集合。
// 如果是完美矩形，那么最后set剩余的必定是大矩形的四个角。因为如果是完美矩形，其他点必定出现偶数次

    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {

//            Arrays.sort(rectangles,(o1, o2)->Arrays.compare(o1,o2));
            HashSet<String> set = new HashSet<>();
            int minLeft = 0x7fffffff;
            int minBottom = 0x7fffffff;
            int maxRight = 0x80000000;
            int maxTop = 0x80000000;
            int totArea = 0;
            for(int[] item:rectangles){
                String a = item[0]+""+item[1];
                String b = item[2]+""+item[3];
                String c = item[0]+""+item[3];
                String d = item[2]+""+item[1];
                String[] str = {a,b,c,d};
                for(String s:str) {
                    if (set.contains(s)) {
                        set.remove(s);
                    }else {
                        set.add(s);
                    }
                }

                minLeft = minLeft<item[0]?minLeft:item[0];
                minBottom = minBottom<item[1]?minBottom:item[1];
                maxRight = maxRight>item[2]?maxRight:item[2];
                maxTop = maxTop>item[3]?maxTop:item[3];
                totArea += (item[3]-item[1])*(item[2]-item[0]);
            }
            int row = maxTop-minBottom;
            int column = maxRight-minLeft;
//            int[][] zone = new int[row][column];
            int needCover = row*column;
            if(totArea!=needCover || set.size()!=4){
                return false;
            }
            if(!(set.contains(minLeft+""+minBottom) && set.contains(minLeft+""+maxTop) &&
            set.contains(maxRight+""+minBottom) && set.contains(maxRight+""+maxTop))){
                return false;
            }
            return true;
//            int coverCount = 0;
//            for(int[] item:rectangles){
//                for(int i=item[0];i<item[2];i++){
//                    for(int j=item[1];j<item[3];j++){
//                        int y = i-minLeft;
//                        int x = j-minBottom;
//                        if(zone[x][y] == 1){
//                            return false;
//                        }else{
//                            zone[x][y]=1;
//                            coverCount++;
//                        }
//                    }
//                }
//            }
//            return coverCount<needCover?false:true;
        }
    }
}
