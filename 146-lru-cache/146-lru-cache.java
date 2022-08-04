class LRUCache {
    
    class Node{
        Node prev;
        Node next;
        int value;
        int key;
    }
    
    private HashMap<Integer, Node> map;
    private int capacity;
    
    private Node start; // least recently used
    private Node end; // most recently used 
    
    private int size;
    
    public LRUCache(int capacity) {
        this.map = new HashMap();
        
        this.capacity = capacity;
        this.size = 0;
        
        start = new Node();
        end = new Node();
        
        start.next = end;
        end.prev = start;
    }
    
    private void remove(Node node){
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }
    
    private void add(Node node){
        Node p = this.end.prev;
        p.next = node;
        node.prev = p;
        end.prev = node;
        node.next = end;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            this.remove(map.get(key));
            this.add(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            this.remove(map.get(key));
            this.add(map.get(key));
        }
        else if(size < capacity){
            map.put(key, new Node());
            Node t = map.get(key);
            t.key = key;
            t.value = value;
            this.add(t);
            size++;
        }else{
            int k = start.next.key;
            this.remove(start.next);
            map.remove(k);
            map.put(key, new Node());
            Node t = map.get(key);
            t.key = key;
            t.value = value;
            this.add(t);
        }
        

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */