package medium;

public class FlipEquivalentBinaryTrees951 {
    public static FlipEquivalentBinaryTrees951 instance = new FlipEquivalentBinaryTrees951();
    public Solution solution = new Solution();
    TreeNode root1 = new TreeNode(6);
    TreeNode root2 = new TreeNode(6);

    public static void main(String[] args) {
        boolean result = instance.solution.flipEquiv(instance.root1, instance.root2);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            } else if (root1 != null && root2 != null) {
                if (root1.val != root2.val) {
                    return false;
                }
                return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));

            } else {
                return false;
            }
        }
    }
}

