import leetcode.design.Codec;
import leetcode.design.WordDictionary;
import leetcode.design.util.TreeNode;

public class Main {

    public static void main(String[] args) {
        var root = new Codec();
        var node = new TreeNode();

        node.val = 1;
        var node2 = new TreeNode();
        node2.val = 2;
        var node3 = new TreeNode();
        node3.val = 3;
        var node4 = new TreeNode();
        node4.val = 4;
        var node5 = new TreeNode();
        node5.val = 5;
        var node6 = new TreeNode();
        node6.val = 99;

        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        node5.right = node6;

        System.out.println(root.serialize(node));
        System.out.println(root.deserialize(""));
        System.out.println(node);
    }
}