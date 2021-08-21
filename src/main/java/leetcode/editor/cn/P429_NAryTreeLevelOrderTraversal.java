package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//429-N-ary Tree Level Order Traversal
public class P429_NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        Solution solution = new P429_NAryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


    class Solution {

        public List<List<Integer>> levelOrder(Node root) {

            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> result = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                List<Integer> level = new ArrayList<>(queue.size());
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.val);
                    //                    if (poll.children != null && poll.children.size() > 0) {
                    queue.addAll(node.children);
                    //                    }
                }
                result.add(level);
            }
            return result;

        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    class Node {

        public int val;

        public List<Node> children;


        public Node() {
        }


        public Node(int _val) {
            val = _val;
        }


        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    ;
}