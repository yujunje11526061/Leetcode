package easy;

import java.util.*;

public class UncommonWordsfromTwoSentences884 {
    public static UncommonWordsfromTwoSentences884 instance = new UncommonWordsfromTwoSentences884();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String A = "apple apple", B = "banana";
        System.out.println(Arrays.toString(instance.solution.uncommonFromSentences(A, B)));
    }

    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> count = new HashMap();
            for (String word : A.split(" "))
                count.put(word, count.getOrDefault(word, 0) + 1);
            for (String word : B.split(" "))
                count.put(word, count.getOrDefault(word, 0) + 1);

            List<String> ans = new LinkedList();
            for (String word : count.keySet())
                if (count.get(word) == 1)
                    ans.add(word);

            return ans.toArray(new String[ans.size()]);
        }
    }
}
