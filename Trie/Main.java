package Trie;



public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        String[] commonPrefix = {
                "car",
                "carpool",
                "carpet"
        };

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

        for(String word: commonPrefix) {
            trie.insert(word);
        }

//        System.out.println(  trie.autoComplete("bag"));
        System.out.println(trie.getLongestCommonPrefix());
    }
}
