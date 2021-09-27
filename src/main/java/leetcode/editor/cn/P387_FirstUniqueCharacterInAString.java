package leetcode.editor.cn;

import java.util.HashMap;
import java.util.TreeSet;


//387-字符串中的第一个唯一字符
public class P387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {

        Solution solution = new P387_FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int firstUniqChar(String s) {
            //方法1;

            return useObj(s);
            ///方法2:还可以将得到的nodes进行遍历,发现第一个1也行.就不写了;
        }


        private int useObj(String s) {
            if (s == null || s.length() == 0) {
                return -1;
            }

            char[] chars = s.toCharArray();
            HashMap<Integer, Node> nodes = new HashMap<>();
            //o(n)
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (nodes.get(index) == null) {
                    nodes.put(index, new Node(i));
                }else {
                    Node node = nodes.get(index);
                    node.cnt = node.cnt + 1;
                }
            }
            //o(n)
            TreeSet<Node> results = new TreeSet<>(nodes.values());
            Node first = results.first();

            return first.cnt > 1 ? -1 : first.index;
        }
    }


    class Node implements Comparable<Node> {

        public int index;

        public int cnt;


        public Node(int index) {
            this.index = index;
            this.cnt = 1;
        }


        @Override
        public int compareTo(Node o) {
            if (cnt != o.cnt) {
                return cnt - o.cnt;
            }

            return index - o.index;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}