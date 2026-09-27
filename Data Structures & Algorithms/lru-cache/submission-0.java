class Node {
  int key;
  int val;
  Node next;
  Node prev;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

public class LRUCache {
  Map<Integer, Node> cache;
  int capacity = 0;
  Node left;
  Node right;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.left = new Node(0, 0);
    this.right = new Node(0, 0);
    this.left.next = right;
    this.right.prev = left;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      remove(node);
      insert(node);
      return node.val;
    }
    return -1;
  }

  private void remove(Node node) {
    Node prv = node.prev;
    Node nxt = node.next;
    prv.next = nxt;
    nxt.prev = prv;
  }

  private void insert(Node node) {
    Node pre = right.prev;
    pre.next = node;
    node.prev = pre;
    node.next = right;
    right.prev = node;
  }

  public void put(int key, int value) {
    Node node = new Node(key, value);
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    insert(node);
    cache.put(key, node);
    while (cache.size() > capacity) {
      Node lru = this.left.next;
      remove(lru);
      cache.remove(lru.key);
    }
  }
}