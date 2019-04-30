package medium;

public class ConstructBinaryTreefromPreorderandPostorderTraversal889 {
    public static ConstructBinaryTreefromPreorderandPostorderTraversal889 instance = new ConstructBinaryTreefromPreorderandPostorderTraversal889();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        TreeNode root = instance.solution.constructFromPrePost(pre, post);
        instance.inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val);
        inOrderTraversal(node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int[] pre;
        int[] post;
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            this.pre = pre;
            this.post = post;
            TreeNode root = construct(0,pre.length-1,0,post.length-1);
            return root;
        }

        private TreeNode construct(int a, int b, int x, int y) {
            if(a>b){
                return null;
            }
            TreeNode root = new TreeNode(pre[a]);
            if(a==b){
                return root;
            }
            int i;
            for(i=x;i<y;i++){
                if(post[i]==pre[a+1]){
                    break;
                }
            }
            int len = i-x+1;
            root.left = construct(a+1,a+len,x,x+len-1);
            root.right = construct(a+len+1,b,x+len,y-1);
            return root;
        }
    }
}
