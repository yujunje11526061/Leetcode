package easy;

public class BinaryGap868 {
    public static BinaryGap868 instance= new BinaryGap868();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.binaryGap(22));
    }

    class Solution {
        public int binaryGap(int N) {
            if((N&(-N)) == N){
                return 0;
            }
            boolean flag = false;
            int cnt0 = 0;
            int maxCnt0 = 0;
            while(N>0){
                int end = N&1;
                if(end==0) {
                    if (flag){
                        cnt0++;
                        maxCnt0 = maxCnt0>cnt0?maxCnt0:cnt0;
                    }
                }else{
                    flag=true;
                    cnt0=0;
                }
                N >>=1;
            }
            return maxCnt0+1;
        }
    }
}
