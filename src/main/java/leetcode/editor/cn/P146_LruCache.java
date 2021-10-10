package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//146-LRU 缓存机制
public class P146_LruCache {

    public static void main(String[] args) {
        LRUCache lruCache = new P146_LruCache().new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        Map<Integer, Node> map;

        LinkedList<Node> queue;

        int maxSize;


        public LRUCache(int capacity) {
            map = new HashMap<>(2 * capacity);
            queue = new LinkedList<>();
            maxSize = capacity;
        }


        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                //将其移动到最新一个
                queue.remove(node);
                queue.addLast(node);
                return node.value;
            }
            return -1;

        }


        public void put(int key, int value) {
            Node node = new Node();
            node.key = key;
            node.value = value;
            Node old = map.put(key, node);
            if (old != null) {
                //这里复杂度O(n),可以想办法减少
                queue.removeFirstOccurrence(old);
                queue.addLast(node);
                return;
            }
            if (queue.size() >= maxSize) {
                Node oldNode = queue.pollFirst();
                map.remove(oldNode.key);
            }

            queue.addLast(node);

        }
    }


    class Node {

        int key;

        int value;

    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}