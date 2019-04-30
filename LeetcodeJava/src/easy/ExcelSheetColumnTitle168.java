package easy;

public class ExcelSheetColumnTitle168 {
    public static ExcelSheetColumnTitle168 instance = new ExcelSheetColumnTitle168();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(instance.solution.convertToTitle(701));
        System.out.println(instance.solution.change(2-1));
    }

    class Solution {
        public String convertToTitle(int n) {
            StringBuilder stringBuilder = new StringBuilder();
            while(n>0){
                stringBuilder.append(change((n-1)%26));
                n = (n-1)/26;
            }
//            stringBuilder.append(change(n));

            return stringBuilder.reverse().toString();
        }

        private char change(int x){
            return (char)('A'+ x);
        }
    }
}
