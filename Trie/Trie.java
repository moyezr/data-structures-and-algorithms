package Trie;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class TrieNode {
    char value;
    private Map<Character, TrieNode> children;

    public boolean isEndOfWord;

    TrieNode(char value) {
        this.value = value;
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }

    public boolean hasChild(char ch) {
        return this.children.containsKey(ch);
    }

    public void insertChild(char ch) {
        this.children.put(ch, new TrieNode(ch));
    }

    public TrieNode getChild(char ch) {
        return this.children.get(ch);
    }

    public TrieNode[] getAllChildren() {
        return this.children.values().toArray(new TrieNode[0]);
    }

    public void removeChild(TrieNode node) {
        this.children.remove(node.value);
    }
    public String toString() {
        return "" + value;
    }

}

public class Trie {
    private TrieNode root;

    Trie() {
        this.root = new TrieNode(' ');
    }


    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toLowerCase().toCharArray()) {
            // If there is no child for ch in current, we've to create one.
            if (!current.hasChild(ch))
                current.insertChild(ch);

            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }

    private void searchForAllPossibleWords(TrieNode node, String pre, List<String> result) {
        if(node == null) return;


        if(node.isEndOfWord) {
            result.add(pre);
        }

        for(TrieNode child: node.getAllChildren()) {
            searchForAllPossibleWords(child, pre + child.value, result);
        }
    }
    public TrieNode getLastNodeForWordPrefix(TrieNode root, String prefix, int index) {
        if (index == prefix.length()) {
            return root;
        }

        char ch = prefix.charAt(index);

            TrieNode nextNode = root.getChild(ch);
            return getLastNodeForWordPrefix(nextNode, prefix, index + 1);

    }

    public List<String> autoComplete(String prefix) {
        List<String> result = new ArrayList<>();

        TrieNode startingPoint = getLastNodeForWordPrefix(root, prefix, 0);
//        System.out.println(startingPoint);
        searchForAllPossibleWords(startingPoint, prefix , result);
        return result;
    }

    private void remove(TrieNode root, String word, int index) {
        if(root == null) {
            return;
        }
        if(index == word.length()) {
            root.isEndOfWord = false;
                    return;
        }

        char currentChar = word.charAt(index);
        TrieNode currentNode = root.getChild(currentChar);
        if(currentNode == null) {
            return;
        }
        remove(currentNode, word, index + 1);

        if(currentNode.getAllChildren().length == 0 && !currentNode.isEndOfWord) {
            root.removeChild(currentNode);
        }
    }
    public void remove(String word) {

    }
}
