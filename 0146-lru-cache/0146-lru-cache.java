class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cache;
    private Deque<Integer> recentlyUsed;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        recentlyUsed=new LinkedList<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            recentlyUsed.remove(key);
            recentlyUsed.addFirst(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            recentlyUsed.remove(key);
        }
        else if(cache.size()>=capacity){
            int removed= recentlyUsed.removeLast();
            cache.remove(removed);
        }

        cache.put(key,value);
        recentlyUsed.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */