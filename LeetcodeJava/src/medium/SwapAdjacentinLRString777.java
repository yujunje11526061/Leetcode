package medium;

import java.util.ArrayList;

public class SwapAdjacentinLRString777 {
    public static SwapAdjacentinLRString777 instance = new SwapAdjacentinLRString777();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String start = "XXXXXXXXL", end = "XXXXXXLXX";
        System.out.println(instance.solution.canTransform(start, end));
    }

    class Solution {
        // L只能跨X左移。R只能跨X右移。
        public boolean canTransform(String start, String end) {
            if (start == null || end == null || start.length() != end.length()) {
                return false;
            }
            if (start.length() == 1 && !start.equals(end)) {
                return false;
            }
            int cntR1 = 0, cntR2 = 0;
            int cntL1 = 0, cntL2 = 0;
            int cntX1 = 0, cntX2 = 0;
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'R') {
                    cntR1++;
                }
                if (end.charAt(i) == 'R') {
                    cntR2++;
                }
                if (start.charAt(i) == 'X') {
                    cntX1++;
                }
                if (cntR1 == cntR2 && cntR1 > 0) {
                    if (cntL1 != cntL2 || cntX1 != cntX2) {
                        return false;
                    }
                    cntR1 = 0;
                    cntR2 = 0;
                    cntL1 = 0;
                    cntL2 = 0;
                    cntX1 = 0;
                    cntX2 = 0;
                }
                if (start.charAt(i) == 'L') {
                    cntL1++;
                }

                if (end.charAt(i) == 'L') {
                    cntL2++;
                }
                if (end.charAt(i) == 'X') {
                    cntX2++;
                }
            }
            cntR1 = 0;
            cntR2 = 0;
            cntL1 = 0;
            cntL2 = 0;
            cntX1 = 0;
            cntX2 = 0;
            for (int i = start.length() - 1; i >= 0; i--) {
                if (start.charAt(i) == 'L') {
                    cntL1++;
                }
                if (end.charAt(i) == 'L') {
                    cntL2++;
                }
                if (start.charAt(i) == 'X') {
                    cntX1++;
                }
                if (cntL1 == cntL2 && cntL1 > 0) {
                    if (cntR1 != cntR2 || cntX1 != cntX2) {
                        return false;
                    }
                    cntR1 = 0;
                    cntR2 = 0;
                    cntL1 = 0;
                    cntL2 = 0;
                    cntX1 = 0;
                    cntX2 = 0;
                }
                if (start.charAt(i) == 'R') {
                    cntR1++;
                }

                if (end.charAt(i) == 'R') {
                    cntR2++;
                }
                if (end.charAt(i) == 'X') {
                    cntX2++;
                }
            }
            return true;
        }
    }
}
