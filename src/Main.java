import leetcode.design.WordDictionary;

public class Main {

    public static void main(String[] args) {
        var root = new WordDictionary();
        root.addWord("bad");
        root.addWord("dad");
        root.addWord("mad");
        System.out.println(root.search("bad"));
        System.out.println(root.search(".ad"));
        System.out.println(root.search("b.."));
        System.out.println(root.search("w.."));
    }
}