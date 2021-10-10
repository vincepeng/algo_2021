package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;


//146-LRU 缓存机制
public class P146_LruCache_Use_Link_HashMap {

    public static void main(String[] args) {

        //        LRUCache solution = new P146_LruCache().new LRUCache();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache extends LinkedHashMap {


        LinkedHashMap<Integer, Integer> lruMap;

        private int maxSize;


        public LRUCache(int capacity) {

            //更具访问顺序进行删除;
            super(capacity, 1, true);
            maxSize = capacity;

        }


        public int get(int key) {
            Object o = super.get(key);
            return o == null ? -1 : (int) o;
        }


        public void put(int key, int value) {
            super.put(key, value);
        }


        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            //因为这个是后置执行,因此相等时会删除,确保不会超过最大的容量;
            return size() > maxSize;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}