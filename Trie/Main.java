package Trie;



public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        String[] words = new String[]{
                "cat",
                "car",
                "carpool",
                "carpool",
                "carpooling",
                "coding",
                "coder",
                "codecommunity",
                "book",
                "bag",
                "baggage"
        };

        for(String word: words) {
            trie.insert(word);
        }

        System.out.println(  trie.autoComplete("bag"));
    }
}
