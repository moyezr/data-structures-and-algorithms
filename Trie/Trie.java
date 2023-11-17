package Trie;

import javax.swing.plaf.basic.BasicTreeUI;
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

    public String toString() {
        return ""+value;
    }

}
public class Trie {
    private TrieNode root;

    Trie() {
        this.root = new TrieNode(' ');
    }


    public void insert(String word) {
        TrieNode current = root;

        for(char ch:  word.toLowerCase().toCharArray()) {
            // If there is no child for ch in current, we've to create one.
            if(!current.hasChild(ch))
                current.insertChild(ch);

            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }
}
