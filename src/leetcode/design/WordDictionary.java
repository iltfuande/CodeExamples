package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private final TrieNode dictionary;

    public WordDictionary() {
        dictionary = new TrieNode();
    }

    public void addWord(String word) {
        var root = dictionary;
        for (var character : word.toCharArray()) {
            root.children.putIfAbsent(character, new TrieNode());
            root = root.children.get(character);
        }
        root.isWord = true;
    }

    public boolean search(String word) {
        return recursiveSearch(word, 0, dictionary);
    }

    private boolean recursiveSearch(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }

        char character = word.charAt(index);
        if (character == '.' && !node.children.isEmpty()) {
            for (var entry : node.children.entrySet()) {
                if (recursiveSearch(word, index + 1, entry.getValue())) {
                    return true;
                }
            }
            return false;
        } else {
            return node.children.containsKey(character) && recursiveSearch(word, index + 1, node.children.get(character));
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}