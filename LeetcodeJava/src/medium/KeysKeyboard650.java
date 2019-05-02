package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeysKeyboard650 {
    public static KeysKeyboard650 instance = new KeysKeyboard650();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.minSteps(555));
    }

    class Solution {
        // 即分解质因数。
        public int minSteps(int n) {
            int res = 0;
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    res += i;
                    n /= i;
                }
            }
            return res;
        }
    }
}
