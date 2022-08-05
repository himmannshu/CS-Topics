class WordDictionary {
    
    class Node{
        Node[] nodes = new Node[26];
        boolean isEnd;
    }
    
    private Node root;
    
    public WordDictionary() {
        root = new Node();    
    }
    
    public void addWord(String word) {
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
    
    private boolean dfs(Node curr, int index, String word){
        if(index == word.length()){
            return curr.isEnd;
        }
        char ch = word.charAt(index);
        if(ch == '.'){
            for(int i = 0; i<26; i++){
                if(curr.nodes[i] != null && dfs(curr.nodes[i], index + 1, word)){
                    return true;
                }
            }
            return false;
        }else if(curr.nodes[ch - 'a'] == null){
            return false;
        }
        
        return dfs(curr.nodes[ch - 'a'], index + 1, word);
    }
    
    public boolean search(String word) {
        return dfs(root, 0, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */