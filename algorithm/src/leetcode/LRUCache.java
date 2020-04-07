package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * O(1)的时间复杂度实现
 * <p>
 * LRUCache cache = new LRUCache( 2 )2为缓存容量
 * cache.put(1,1)
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * @author lixinglin
 * @date 2020/4/7 12:53 下午
 * @since jdk 1.8
 */
public class LRUCache {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i1 = lruCache.get(1);
        lruCache.put(3, 3);
        int i = lruCache.get(2);
        lruCache.put(4, 4);
        int i2 = lruCache.get(1);
        int i3 = lruCache.get(3);
        int i4 = lruCache.get(4);
    }

    private Map<Integer, LNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private LNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new LRUCache.LNode();
        head.head = null;

        tail = new LRUCache.LNode();
        tail.tail = null;

        head.tail = tail;
        tail.head = head;
    }


    public static class LNode {
        int key;
        int value;
        LNode head;
        LNode tail;
    }

    public int get(int key) {
        LNode lNode = cache.get(key);
        if (null == lNode) {
            return -1;
        }

        moveToHead(lNode);
        return lNode.value;
    }

    public void put(int key, int value) {
        LNode lNode = cache.get(key);
        if (null == lNode) {

            lNode = new LNode();
            lNode.value = value;
            lNode.key = key;
            addNode(lNode);
            cache.put(key, lNode);

            ++count;

            if (capacity < count) {
                //删除队尾元素
                LNode node = popTail();
                cache.remove(node.key);
                count--;
            }
        } else {
            lNode.value = value;
            moveToHead(lNode);
        }
    }

    /**
     * 弹出队尾元素、tail指向原tail的head
     *
     * @return
     */
    private LNode popTail() {
        LNode node = tail.head;
        remove(node);
        return node;
    }

    /**
     * 新增node
     *
     * @param lNode
     */
    private void addNode(LNode lNode) {
        lNode.head = head;
        lNode.tail = head.tail;

        head.tail.head = lNode;
        head.tail = lNode;

    }

    /**
     * 删除node
     *
     * @param lNode
     */
    private void remove(LNode lNode) {
        LNode head = lNode.head;
        LNode tail = lNode.tail;

        lNode.tail.head = head;
        lNode.head.tail = tail;
    }


    /**
     * 移动元素到链表头
     *
     * @param lNode
     */
    private void moveToHead(LNode lNode) {
        remove(lNode);
        addNode(lNode);
    }


}
