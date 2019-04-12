package easy;

public class SearchinaBinarySearchTree700 {
    public static SearchinaBinarySearchTree700 instance= new SearchinaBinarySearchTree700();
    public Solution solution = new Solution();


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode p = root;
            while(p!=null){
                if(p.val<val){
                    p = p.right;
                }else if(p.val>val){
                    p = p.left;
                }else{
                    return p;
                }
            }
            return null;
        }
    }
}
