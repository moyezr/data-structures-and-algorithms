package Trie;

class TrieNode {
    char value;
    public TrieNode[] children;

    public boolean isEndOfWord;

    TrieNode(char value) {
        this.value = value;
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
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
            int index = ch - 'a';

            if(current.children[index] == null) {
                current.children[index] = new TrieNode(ch);
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }
}
