package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords692 {
    public static TopKFrequentWords692 instance = new TopKFrequentWords692();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"};
        String[] words3 = {"rmrypv","zgsedk","jlmetsplg","wnfbo","hnnftqf","bxlr","sviavwoxss","jdbgvc","zddeno","rxgw","hnnftqf","hdmvplne","rlmdt","jlmetsplg","ous","rmrypv","fwxulnpit","dmhuq","rxgw","ledleb","bxlr","indbvb","ckqqibnx","cub","ijww","ehd","hfhlfqzkcn","sviavwoxss","rxgw","bxjxpfp","mgqj","oic","ptk","fwxulnpit","ijww","sviavwoxss","bgfvfa","zfkgsudxq","alkq","dmhuq","zddeno","rxgw","zgsedk","amarxpg","bgfvfa","wnfbo","sviavwoxss","sviavwoxss","alkq","nmclxk","zgsedk","bwowfvira","ous","bxlr","zddeno","rxgw","ous","wnfbo","rmrypv","sviavwoxss","ehd","zgsedk","jlmetsplg","abxvhyehv","ledleb","wnfbo","bgfvfa","bwowfvira","amarxpg","wnfbo","bwowfvira","dmhuq","ouy","bxlr","rxgw","oic","hnnftqf","ledleb","rlmdt","oldainprua","ous","ckqqibnx","dmhuq","hnnftqf","oic","jlmetsplg","ppn","amarxpg","jlgfgwb","bxlr","bwowfvira","hdmvplne","oic","ledleb","bwowfvira","oic","ptk","dmhuq","abxvhyehv","ckqqibnx","indbvb","ypzfk","rmrypv","bxjxpfp","amarxpg","dmhuq","sviavwoxss","bwowfvira","zfkgsudxq","wnfbo","rxgw","jxkvrmajri","cub","abxvhyehv","bwowfvira","indbvb","ehd","ckqqibnx","oic","ptk","hnnftqf","ouy","oic","zgsedk","abxvhyehv","ypzfk","ptk","sviavwoxss","rmrypv","oic","ous","abxvhyehv","hnnftqf","hfhlfqzkcn","ledleb","cub","ppn","zddeno","indbvb","oic","jlmetsplg","ouy","bwowfvira","bklij","gucayxp","zfkgsudxq","hfhlfqzkcn","zddeno","ledleb","zfkgsudxq","hnnftqf","bgfvfa","jlmetsplg","indbvb","ehd","wnfbo","hnnftqf","rlmdt","bxlr","indbvb","jdbgvc","jlmetsplg","cub","jlgfgwb","ypzfk","indbvb","dmhuq","jlmetsplg","zgsedk","rmrypv","cub","rxgw","ledleb","rxgw","sviavwoxss","ckqqibnx","hdmvplne","dmhuq","wnfbo","jlmetsplg","bxlr","zfkgsudxq","bxjxpfp","ledleb","indbvb","ckqqibnx","ous","ckqqibnx","cub","ous","abxvhyehv","bxlr","hfhlfqzkcn","hfhlfqzkcn","oic","ten","amarxpg","indbvb","cub","alkq","alkq","sviavwoxss","indbvb","bwowfvira","ledleb"};
        int k = 41;
        System.out.println(instance.solution.topKFrequent(words3, k));
    }


    class Solution {
        private HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> heap = new ArrayList<>();

        public List<String> topKFrequent(String[] words, int k) {
            for (String word : words) {
                map.merge(word, 1, Integer::sum);
            }

            map.forEach((K, V) -> {
                if (heap.size() < k) {
                    insert(K);
                } else if (largerThan(K, heap.get(0)) == 1) {
                    replaceHead(K);
                }
            });
            heap.sort((o1, o2) -> -largerThan(o1, o2));
            return heap;
        }

        private int largerThan(String a, String b) {
            if (map.get(a) > map.get(b)) {
                return 1;
            } else if (map.get(a) == map.get(b)) {
                int i = 0;
                for (; i < a.length() && i < b.length(); i++) {
                    if (a.charAt(i) < b.charAt(i)) {
                        return 1;
                    } else if (a.charAt(i) > b.charAt(i)) {
                        return -1;
                    }
                }
                return i == a.length() ? 1 : -1;
            } else {
                return -1;
            }
        }

        private void insert(String s) {
            heap.add(s);
            int i = heap.size() - 1;
            int j = (i - 1) / 2;
            while (i > 0) {
                if (largerThan(s, heap.get(j)) == 1) {
                    break;
                }
                heap.set(i, heap.get(j));
                i = j;
                j = (i - 1) / 2;
            }
            heap.set(i, s);
        }

        private void replaceHead(String s) {
//            heap.set(0,s);
            int i = 0;
            int j = 2 * i + 1;
            while (j < heap.size()) {
                if (j + 1 < heap.size() && largerThan(heap.get(j), heap.get(j + 1)) == 1) {
                    j = j + 1;
                }
                if (largerThan(s, heap.get(j)) == -1) {
                    break;
                }
                heap.set(i, heap.get(j));
                i = j;
                j = i * 2 + 1;

            }
            heap.set(i, s);
        }
    }
}
