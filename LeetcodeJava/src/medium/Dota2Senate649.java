package medium;

public class Dota2Senate649 {
    public static Dota2Senate649 instance = new Dota2Senate649();
    public Solution solution  = new Solution();

    public static void main(String[] args) {
        String senate = "RDDR";
        String result = instance.solution.predictPartyVictory(senate);
        System.out.println(result);
    }

    class Solution {
        public String predictPartyVictory(String senate) {
            Boolean started = false;
            int cntR = 0, cntD = 0, bar = 0;
            while((cntR > 0 && cntD>0 ) || !started ) {
                cntR=cntD =0;
                started = true;
                StringBuilder str = new StringBuilder();
                for(int i=0;i<senate.length();i++){
                    char s = senate.charAt(i);
                    if(s=='R'){
                        if(bar>=0){
                            cntR++;
                            bar++;
                            str.append(s);
                        }else{
                            bar++;
                        }
                    }else if(s=='D'){
                        if(bar<=0){
                            cntD++;
                            bar--;
                            str.append(s);
                        }else{
                            bar--;
                        }
                    }
                }
                senate = str.toString();
            }
            return cntR>0?"Radiant":"Dire";

        }
    }
}
