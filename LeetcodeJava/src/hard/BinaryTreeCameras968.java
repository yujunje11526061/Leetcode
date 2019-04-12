package hard;

public class BinaryTreeCameras968 {
    public static BinaryTreeCameras968 instance = new BinaryTreeCameras968();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(0);
        a.left = b;
        TreeNode c = new TreeNode(0);
        TreeNode d = new TreeNode(0);
//        TreeNode e = new TreeNode(0);
        b.left = c;
        c.left = d;
        System.out.println(instance.solution.minCameraCover(a));
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
        private int cnt = 0;

        public int minCameraCover(TreeNode root) {
            this.cnt = (dfs(root) == 0 ? 1 : 0) + this.cnt;
//            this.cnt += (dfs(root)==0?1:0);
//            this.cnt = this.cnt +  (dfs(root)==0?1:0);
//            不能写成以上两种形式，此时原先cnt的值进入寄存器，而不是dfs过程中更新的最新的cnt。
            return this.cnt;
        }

        // 总共三种状态：0.不可见，1.可见但没装相机，2.可见且装了相机
        private int dfs(TreeNode node) {
            if (node == null) {
                return 1;
            }
            int left = dfs(node.left);
            int right = dfs(node.right);
            if (left == 0 || right == 0) {
                this.cnt++;
                return 2;
            } else if (left == 2 || right == 2) {
                return 1;
            } else {
                return 0;
            }

        }
    }
}
