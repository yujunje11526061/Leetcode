package medium;

import java.util.*;

public class FindKPairswithSmallestSums373 {
    public static FindKPairswithSmallestSums373 instance = new FindKPairswithSmallestSums373();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {3, 5, 7};
        int k = 3;
        List<int[]> result = instance.solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(Arrays.deepToString(result.toArray(new int[0][])));
    }

    class Solution {
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            if (k == 0 || nums2 == null || nums1 == null || nums1.length == 0 || nums2.length == 0) {
                return new ArrayList<int[]>();
            }

            Queue<Pair> pq = new PriorityQueue<Pair>((o1, o2) -> o2.x+o2.y-o1.x-o1.y);
            for (int i = 0; i < k && i < nums1.length; i++) {
                for (int j = 0; j < k && j < nums2.length; j++) {
                    Pair temp = new Pair(nums1[i], nums2[j]);
                    if(pq.size()<k){
                        pq.offer(temp);
                    }else if(pq.peek().compareTo(temp)>0){
                        pq.poll();
                        pq.offer(temp);
                    }
                }
            }
//            while(pq.size()>0) {
//                System.out.println(Arrays.toString(pq.poll().toArray()));
//            }
            List<int[]> result = new ArrayList<>();
            for(Pair p:pq){
                result.add(p.toArray());
            }
            return result;
        }
    }

    class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int[] toArray() {
            int[] temp = {this.x, this.y};
            return temp;
        }

        public int compareTo(Pair o) {
            return this.x + this.y - o.x - o.y;
        }
    }
}
