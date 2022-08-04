class Trie {
    class Node{
        Node[] nodes = new Node[26];
        boolean isEnd;
        
    }
    
    private Node root;
    
    public Trie() {
       root = new Node(); 
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.nodes[ch - 'a'] != null){
                curr = curr.nodes[ch - 'a'];
                
            }else{
                curr.nodes[ch - 'a'] = new Node();
                curr = curr.nodes[ch - 'a'];
            }
        }
        curr.isEnd = true;
        
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.nodes[ch - 'a'] == null) return false;
            curr = curr.nodes[ch - 'a'];
        }
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.nodes[ch - 'a'] == null) return false;
            curr = curr.nodes[ch - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */