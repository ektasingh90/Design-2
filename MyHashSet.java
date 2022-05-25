class MyHashSet {

    private boolean[][] storage;
    int buckets;
    int bucketItems;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
        
    }
    
    private int bucket(int key){
        return key % buckets;
    }
    
    private int bucketItems(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket]==null){
            if(bucket == 0)
            {
            storage[bucket] = new boolean[bucketItems + 1];
            } else
            {
                storage[bucket]= new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]= true;
        
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
           if(storage[bucket]== null) return;
        storage[bucket][bucketItem]= false;
        
    }
    
    public boolean contains(int key) {
        int bucket= bucket(key);
        int bucketItem = bucketItems(key);
        if (storage[bucket]== null) return false;
        return storage[bucket][bucketItem];
        
    }

   public static void main(String[] args) {
     MyHashSet obj = new MyHashSet();
     obj.add(8);
     obj.remove(8);
     boolean param_3 = obj.contains(8);
     System.out.println(param_3);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */