import java.util.*;

public class Trie {
    static class Node {
        boolean isWord;
        Node[] nodes = new Node[26];

        public Node() {
            isWord = false;
            for (int i = 0; i < 26; i++) {
                nodes[i] = null;
            }
        }
    }

    static Node root;

    public static void main(String[] args) {
        root = new Node();
        String[] words = new String[] { "bubble", "cat", "catch" };
        for (String word : words) {
            insert(word);
        }
        System.out.println(search("buble"));
    }

    private static void insert(String key) {
        Node current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.nodes[index] == null) {
                current.nodes[index] = new Node();
            }
            current = current.nodes[index];
        }
        current.isWord = true;
    }

    private static boolean search(String key) {
        Node curr = root;
        for (char ch : key.toCharArray()) {
            if (curr.nodes[ch - 'a'] == null) {
                return false;
            }
            curr = curr.nodes[ch - 'a'];
        }

        return curr.isWord;
    }

}
