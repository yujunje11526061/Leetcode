package hard;

public class SimilarStringGroups839 {
    public static SimilarStringGroups839 instance = new SimilarStringGroups839();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        String[] A = {"tars","rats","arts","star"};
        String[] B = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
        System.out.println(instance.solution.numSimilarGroups(B));
    }
    class Solution {
        int[] father;
        public int numSimilarGroups(String[] A) {
            father = new int[A.length];
            for(int i=0;i<father.length;i++){
                father[i] = -1;
            }
            for(int i=0;i<A.length;i++){
                for(int j=0;j<i;j++){
                    if(findFather(i)!=findFather(j) && isSimilar(A[i], A[j])){
                        union(i,j);
                    }
                }
            }
            int cnt = 0;
            for(int i=0;i<father.length;i++){
                if(father[i]<0){
                    cnt++;
                }
            }
            return cnt;
        }

        private void union(int i, int j) {
            int fi = findFather(i);
            int fj = findFather(j);
            if(fi!=fj){ // 按秩归并
                if(father[fi]<father[fj]){
                    father[fi] += father[fj];
                    father[fj] = fi;
                    father[j] = fi;
                }else{
                    father[fj] += father[fi];
                    father[fi] = fj;
                    father[i] = fj;
                }
            }
        }

        private int findFather(int i) {
            if(father[i]<0){
                return i;
            }
            father[i] = findFather(father[i]); // 路径压缩
            return father[i];
        }

        private boolean isSimilar(String x, String y){
            if(x==null || y==null || x.length()!=y.length()){
                return false;
            }
            int cnt=0;
            for(int i=0;i<x.length();i++){
                if(x.charAt(i)!=y.charAt(i)){
                    cnt++;
                }
            }
            return cnt==0||cnt==2;
        }
    }
}
