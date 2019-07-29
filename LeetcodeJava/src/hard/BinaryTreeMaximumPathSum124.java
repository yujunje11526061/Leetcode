package hard;

public class BinaryTreeMaximumPathSum124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] result = find(root);
            return Math.max(result[0],result[1]);
        }

        private int[] find(TreeNode node) {
            int[] left = null;
            int[] right = null;

            if(node.left!=null){
                left = find(node.left);
            }
            if(node.right!=null){
                right = find(node.right);
            }

            int[] now = new int[2]; // 第一个表示内部最大，不和父节点连线，第二个表示该子树所贡献的最大的半条路，可以给父节点连
            if(left==null && right==null){
                now[0] = node.val;
                now[1] = node.val;
            }else if(left!=null && right!=null) {
                if (node.val <= 0) {
                    now[0] = Math.max(
                                Math.max( // 单侧贡献
                                        Math.max(left[0],right[0]),
                                        Math.max(left[1],right[1])
                                ),
                                left[1] + right[1] + node.val // 双侧串联贡献
                            );
                } else {
                    now[0] = Math.max(
                                Math.max(
                                        Math.max(left[0], right[0]),
                                        Math.max(left[1], right[1])+node.val
                                ),
                                left[1] + right[1] + node.val
                            );
                }
                now[1] = Math.max(left[1], right[1]) + node.val;

            }else if(left==null && right!=null){
                if (node.val <= 0) {
                    now[0] = Math.max(right[0], right[1]);
                } else {
                    now[0] = Math.max(right[0],right[1]+node.val);
                }

                now[1] = right[1] + node.val;
            }else{
                if (node.val <= 0) {
                    now[0] = Math.max(left[0], left[1]);
                } else {
                    now[0] = Math.max(left[0], left[1] + node.val);
                }

                now[1] = left[1] + node.val;
            }

            now[0] = Math.max(now[0],node.val); // 都不贡献
            now[1] = Math.max(now[1],node.val); // 都不贡献

            return now;
        }
    }
}
