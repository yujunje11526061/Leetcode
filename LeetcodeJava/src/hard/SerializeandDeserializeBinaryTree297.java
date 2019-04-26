package hard;

import java.util.*;

public class SerializeandDeserializeBinaryTree297 {
    public static SerializeandDeserializeBinaryTree297 instance = new SerializeandDeserializeBinaryTree297();
    public Codec codec = new Codec();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.right = b;
        b.left = c;
        b.right = d;
        d.left = e;
        String x = instance.codec.serialize(a);
        System.out.println(x);
        TreeNode xnode = instance.codec.deserialize(x);
        System.out.println(instance.codec.serialize(xnode));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = new ArrayList<>();
            if(root==null){
                return list.toString();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int cnt = 1;
            while(cnt>0){
                TreeNode node = queue.removeFirst();
                if(node==null){
                    list.add("null");
                }else{
                    cnt--;
                    list.add(""+node.val);
                    if(node.left!=null){
                        cnt++;
                    }
                    if(node.right!=null){
                        cnt++;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            return list.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("[]")) {
                return null;
            }
            String[] strings = data.substring(1,data.length()-1).split(", ");
            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode pre = null;
            TreeNode root = null;
            boolean flag = true;
            for(String s:strings){
                TreeNode temp = null;
                if(!s.equals("null")) {
                    temp = new TreeNode(Integer.valueOf(s));
                    queue.add(temp);
                }
                if(root==null){
                    root = temp;
                }else {
                    if (flag) {
                        pre = queue.removeFirst();
                        pre.left = temp;
                        flag = false;
                    } else {
                        pre.right = temp;
                        flag = true;
                    }
                }
            }
            return root;

        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
