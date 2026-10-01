import java.util.LinkedList;

public class HashMap <K, V> {
    class Node {
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    LinkedList[] buckets;
    int currSize;

    public HashMap() {
        init(10);
        currSize = 0;
    }

    public void put(K key, V value) {
        int ind = hash(key); //get the index
        LinkedList<Node> curr = buckets[ind];
        for(Node node: curr) {
            if(node.key.equals(key)) { // check if value already exists - update the value
                node.value = value;
                return;
            }
        }
        curr.add(new Node(key, value));
        currSize++;

         // we need to check the oad factor
        double lambda = (double)currSize/buckets.length;

        if(lambda > 0.75) {
            reHash();
        }
    }

    public V get(K key) {
        int ind = hash(key);
        LinkedList<Node> curr = buckets[ind];
        for(Node node: curr) {
            if(node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int ind = hash(key);
        LinkedList<Node> curr = buckets[ind];
        for(int i = 0; i<curr.size(); i++) {
            Node node = curr.get(i);
            if(node.key.equals(key)) {
                V value = node.value;
                curr.remove(i);
                currSize--;
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int ind = hash(key);
        LinkedList<Node> curr = buckets[ind];
        for (Node node : curr) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return currSize;
    }

    public int hash(K key) {
        int hc = key.hashCode();
        return hc % buckets.length;
    }

    public void reHash() {
        LinkedList<Node>[] oldBuckets = buckets;
        init(oldBuckets.length*2);
        currSize = 0;
        for (LinkedList<Node> curr : oldBuckets) {
            for (Node node : curr) {
                put(node.key, node.value);
            }
        }
    }

    public void init(int size) {
        buckets = new LinkedList[size];
        for(int i = 0; i<size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

}
