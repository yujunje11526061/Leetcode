package easy;

import java.util.Arrays;

public class Heaters475 {
    public static Heaters475 instance = new Heaters475();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] house = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};

        int[] heaters = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        System.out.println(instance.solution.findRadius(house, heaters));
    }

//    对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
//    对于所有的房屋，选择最大的上述距离。
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
//            System.out.println(Arrays.toString(houses));
//            System.out.println(Arrays.toString(heaters));
            int result = 0;
            for(int loc:houses) {
                int dist;
                int before = binarySeach(heaters, loc);
                if(before<0){
                    dist = heaters[0]-loc;
                }else if(before==heaters.length-1){
                    dist = loc-heaters[heaters.length-1];
                }else{
                    dist = Math.min(loc-heaters[before], heaters[before+1]-loc);
                }
                result = Math.max(dist, result);
            }
            return result;
        }

        private int binarySeach(int[] heaters, int loc) {
            int s =0,e = heaters.length-1;
            while(s<=e){
                int mid =(s+e)/2;
                if(loc==heaters[mid]){
                    return mid;
                }else if(loc<heaters[mid]){
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }
            return e;
        }
    }
}
