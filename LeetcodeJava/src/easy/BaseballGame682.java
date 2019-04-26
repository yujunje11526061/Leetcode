package easy;

import java.util.ArrayList;

public class BaseballGame682 {
    public static BaseballGame682 instance = new BaseballGame682();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] strings = {"5","-2","4","C","D","9","+","+"};
        System.out.println(instance.solution.calPoints(strings));
    }
    class Solution {
        public int calPoints(String[] ops) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int sum = 0;
            for(String s:ops){
                if(s.equals("C")){
                    if(!arrayList.isEmpty()) {
                        sum -= arrayList.remove(arrayList.size() - 1);;
                    }
                }else if(s.equals("D")){
                    if(!arrayList.isEmpty()) {
                        int v = arrayList.get(arrayList.size()-1)*2;
                        arrayList.add(v);
                        sum += v;
                    }
                }else if(s.equals("+")){
                    if(arrayList.size()>=2) {
                        int v = arrayList.get(arrayList.size()-1) + arrayList.get(arrayList.size()-2);
                        arrayList.add(v);
                        sum += v;
                    }
                }else{
                    int v = Integer.valueOf(s);
                    arrayList.add(v);
                    sum += v;
                }
            }
            return sum;
        }
    }
}
