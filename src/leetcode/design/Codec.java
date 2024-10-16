package leetcode.design;

import leetcode.design.util.TreeNode;

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        var val = root.val;
        var left = root.left;
        var right = root.right;

        return "%d %s %s".formatted(val, serialize(left), serialize(right));
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return new TreeNode();
        }

        var res = data.split(" ");
        return recursionDeserialize(res, new int[1]);
    }

    private TreeNode recursionDeserialize(String[] data, int[] index) {
        if (index[0] >= data.length || data[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        var node = new TreeNode(Integer.parseInt(data[index[0]]));
        index[0]++;
        node.left = recursionDeserialize(data, index);
        node.right = recursionDeserialize(data, index);

        return node;
    }
}
