import leetcode.design.Codec;
import leetcode.design.NumArray;
import leetcode.design.WordDictionary;
import leetcode.design.util.TreeNode;

public class Main {

    public static void main(String[] args) {
        var root = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(root.sumRange(0, 2));
        System.out.println(root.sumRange(2, 5));
        System.out.println(root.sumRange(0, 5));
    }
}